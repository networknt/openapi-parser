/*
 * Copyright (c) 2016 Network New Technologies Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.networknt.openapi;

import com.google.common.io.Resources;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by steve on 23/09/16.
 */
public class OpenApiHelperTest {
    OpenApiHelper helper = null;
    @BeforeEach
    public void testOAuth2Name() throws Exception {
        URL url = Resources.getResource("models/petstore.yaml");
        String spec = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();
        helper = new OpenApiHelper(spec);
        Assertions.assertEquals(1, helper.oauth2Names.size());
        Assertions.assertEquals("petstore_auth", helper.oauth2Names.get(0));
    }

    @AfterEach
    public void tearDown() throws NoSuchFieldException, IllegalAccessException {
        helper = null;
    }

    @Test
    public void testBasePath() {
        Assertions.assertEquals("/v1", helper.basePath);
    }

    @Test
    public void testMergeNull(){
        Map<String, Object> openapi = Map.of("key", "val");
        Map<String, Object> inject = null;
        OpenApiHelper.merge(openapi, inject);
        assertEquals(1, openapi.size());
        assertEquals("val", openapi.get("key"));
    }

    @Test
    public void testMergeMap(){
        Map<String, Object> openapi = new HashMap<>();
        Map<String, Object> inject = new HashMap<>();
        openapi.put("key1", "val1");
        inject.put("key2", "val2");
        OpenApiHelper.merge(openapi, inject);
        assertEquals(2, openapi.size());
        assertEquals("val1", openapi.get("key1"));
        assertEquals("val2", openapi.get("key2"));
    }

    @Test
    public void testMergeMapOverwritten(){
        Map<String, Object> openapi = new HashMap<>();
        Map<String, Object> inject = new HashMap<>();
        openapi.put("key1", "val1");
        inject.put("key1", "val2");
        OpenApiHelper.merge(openapi, inject);
        assertEquals(1, openapi.size());
        assertEquals("val2", openapi.get("key1"));
    }

    @Test
    public void testNestedMap() {
        Map<String, Object> openapi = new HashMap<>();
        Map<String, Object> inject = new HashMap<>();
        Map<String, Object> openapiNested = new HashMap<>();
        Map<String, Object> injectNested = new HashMap<>();
        openapi.put("commonKey", openapiNested);
        openapiNested.put("oKey2", "oVal2");
        inject.put("commonKey", injectNested);
        injectNested.put("iKey2", "iVal2");

        OpenApiHelper.merge(openapi, inject);

        assertEquals(1, openapi.size());
        Map<String, Object> commonMap = (Map<String, Object>) openapi.get("commonKey");
        assertEquals(commonMap.size(), 2);
        assertEquals("oVal2", commonMap.get("oKey2"));
        assertEquals("iVal2", commonMap.get("iKey2"));
    }

    @Test
    public void testNestedMapOverwritten() {
        Map<String, Object> openapi = new HashMap<>();
        Map<String, Object> inject = new HashMap<>();
        Map<String, Object> openapiNested = new HashMap<>();
        Map<String, Object> injectNested = new HashMap<>();
        openapi.put("commonKey", openapiNested);
        openapiNested.put("oKey2", "oVal2");
        inject.put("commonKey", injectNested);
        injectNested.put("oKey2", "iVal2");

        OpenApiHelper.merge(openapi, inject);

        assertEquals(1, openapi.size());
        Map<String, Object> commonMap = (Map<String, Object>) openapi.get("commonKey");
        assertEquals(commonMap.size(), 1);
        assertEquals("iVal2", commonMap.get("oKey2"));
    }

    @Test
    public void testNestedList() {
        Map<String, Object> openapi = new HashMap<>();
        Map<String, Object> inject = new HashMap<>();
        List<Map<String, Object>> openapiNested = new ArrayList<>();
        List<Map<String, Object>> injectNested = new ArrayList<>();
        openapi.put("commonKey", openapiNested);
        openapiNested.add(new HashMap<>(){{put("oKey2", "oVal2");}});
        inject.put("commonKey", injectNested);
        injectNested.add(new HashMap<>(){{put("iKey2", "iVal2");}});

        OpenApiHelper.merge(openapi, inject);

        assertEquals(1, openapi.size());
        List<Map<String, Object>> commonList = (List<Map<String, Object>>) openapi.get("commonKey");
        assertEquals(commonList.size(), 2);
        assertEquals("oVal2", commonList.get(0).get("oKey2"));
        assertEquals("iVal2", commonList.get(1).get("iKey2"));
    }

}
