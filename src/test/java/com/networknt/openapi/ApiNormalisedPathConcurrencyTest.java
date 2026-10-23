package com.networknt.openapi;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ApiNormalisedPathConcurrencyTest {
    private static Map<?, ?> patterns() throws Exception {
        Field field = ApiNormalisedPath.class.getDeclaredField("BASE_PATTERNS");
        field.setAccessible(true);
        return (Map<?, ?>) field.get(null);
    }

    @Test
    void cachedNormalizationDoesNotWaitForCacheMaintenance() throws Exception {
        String base = "/concurrent-hit";
        assertEquals("/pets", new ApiNormalisedPath(base + "/pets", base).normalised());
        try (var executor = Executors.newSingleThreadExecutor()) {
            // Simulate another thread doing serialized cache maintenance. A
            // request using an already compiled pattern must still complete.
            synchronized (patterns()) {
                Future<String> result = executor.submit(() ->
                        new ApiNormalisedPath(base + "/pets", base).normalised());
                assertEquals("/pets", result.get(5, TimeUnit.SECONDS));
            }
        }
    }

    @Test
    void concurrentMissesAndEvictionsKeepResultsCorrectAndCacheBounded() throws Exception {
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
                        assertEquals("/pets", new ApiNormalisedPath(base + "/pets", base).normalised());
                        assertEquals(base + "suffix/pets",
                                new ApiNormalisedPath(base + "suffix/pets", base).normalised());
                        assertTrue(patterns().size() <= 64);
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
        assertTrue(patterns().size() <= 64);
    }
}
