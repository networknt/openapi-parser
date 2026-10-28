package com.networknt.oas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Pinned upstream examples shared by parsing and serialization tests. */
final class SpecExamples {
    private SpecExamples() { }

    static Collection<Object[]> load() throws IOException {
        Collection<Object[]> examples = new ArrayList<>();
        for (String name : List.of("api-with-examples.yaml", "callback-example.yaml",
                "link-example.yaml", "petstore-expanded.yaml", "petstore.yaml", "uspto.yaml")) {
            URL resource = SpecExamples.class.getResource("/oai-examples/" + name);
            if (resource == null) {
                throw new IOException("Missing bundled OpenAPI example: " + name);
            }
            examples.add(new Object[] { resource, name });
        }
        return examples;
    }
}
