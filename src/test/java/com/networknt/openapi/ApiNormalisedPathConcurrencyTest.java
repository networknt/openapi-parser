package com.networknt.openapi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class ApiNormalisedPathConcurrencyTest {
    @Test
    void slowLoadsDoNotBlockCachedPrefixesOrUnrelatedLoads() throws Exception {
        CountDownLatch loading = new CountDownLatch(1);
        CountDownLatch release = new CountDownLatch(1);
        var cache = ApiNormalisedPath.prefixCache(base -> {
            if (base.equals("/slow")) {
                loading.countDown();
                try {
                    if (!release.await(10, TimeUnit.SECONDS)) throw new AssertionError("loader timed out");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new AssertionError(e);
                }
            }
            return ApiNormalisedPath.BasePrefix.compile(base);
        });
        cache.get("/hot");
        try (var executor = Executors.newFixedThreadPool(3)) {
            Future<?> slow = executor.submit(() -> cache.get("/slow"));
            try {
                assertTrue(loading.await(5, TimeUnit.SECONDS));
                assertEquals("/pets", executor.submit(() -> cache.get("/hot").removeFrom("/hot/pets"))
                        .get(5, TimeUnit.SECONDS));
                assertEquals("/pets", executor.submit(() -> cache.get("/other").removeFrom("/other/pets"))
                        .get(5, TimeUnit.SECONDS));
            } finally {
                release.countDown();
            }
            slow.get(5, TimeUnit.SECONDS);
        }
    }

    @Test
    void frequentlyUsedRegexPrefixesSurviveOneOffChurn() {
        AtomicInteger hotLoads = new AtomicInteger();
        var cache = ApiNormalisedPath.prefixCache(base -> {
            if (base.startsWith("/hot-")) hotLoads.incrementAndGet();
            return ApiNormalisedPath.BasePrefix.compile(base);
        });
        for (int round = 0; round < 20; round++) {
            for (int i = 0; i < 63; i++) cache.get("/hot-" + i + "(?:)");
            cache.cleanUp();
        }
        int before = hotLoads.get();
        int hotRequests = 0;
        for (int i = 0; i < 20000; i++) {
            if (i % 10 == 0) {
                cache.get("/one-off-" + i + "(?:)");
            } else {
                int key = i % 63;
                String base = "/hot-" + key;
                assertEquals("/pets", cache.get(base + "(?:)").removeFrom(base + "/pets"));
                hotRequests++;
            }
            cache.cleanUp();
        }
        int reloads = hotLoads.get() - before;
        assertTrue(reloads < hotRequests / 10, "hot prefix reloads: " + reloads + "/" + hotRequests);
        cache.cleanUp();
        assertTrue(cache.estimatedSize() <= 64);
    }

    @Test
    void concurrentMissesAndEvictionsKeepResultsCorrectAndCacheBounded() throws Exception {
        var cache = ApiNormalisedPath.prefixCache(ApiNormalisedPath.BasePrefix::compile);
        CountDownLatch ready = new CountDownLatch(8);
        CountDownLatch start = new CountDownLatch(1);
        try (var executor = Executors.newFixedThreadPool(8)) {
            var results = new ArrayList<Future<?>>();
            for (int worker = 0; worker < 8; worker++) {
                int offset = worker;
                results.add(executor.submit(() -> {
                    ready.countDown();
                    assertTrue(start.await(5, TimeUnit.SECONDS));
                    for (int i = 0; i < 256; i++) {
                        String base = "/concurrent-" + ((i + offset) % 128);
                        var prefix = cache.get(base);
                        assertEquals("/pets", prefix.removeFrom(base + "/pets"));
                        assertEquals(base + "suffix/pets", prefix.removeFrom(base + "suffix/pets"));
                    }
                    return null;
                }));
            }
            assertTrue(ready.await(5, TimeUnit.SECONDS));
            start.countDown();
            for (Future<?> result : results) result.get(20, TimeUnit.SECONDS);
        } finally {
            start.countDown();
        }
        cache.cleanUp();
        assertTrue(cache.estimatedSize() <= 64);
    }
}
