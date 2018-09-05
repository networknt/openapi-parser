package com.networknt.oas;

import com.networknt.jsonoverlay.Overlay;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.Schema;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.io.Resources;

public class Issue131Test extends Assert {

	@Test
	public void testSchemaRefs() throws Exception {
		OpenApi3 model = (OpenApi3) new OpenApiParser().parse(Resources.getResource("models/issue131.yaml"), true);
		assertEquals("SampleData", Overlay.getPathInParent(Overlay.of(model).find("/components/schemas/SampleData")));
		assertEquals("MoreData", Overlay.getPathInParent(Overlay.of(model).find("/components/schemas/MoreData")));
		Schema direct = model.getSchema("SampleData");
		Schema viaMoreData = model.getSchema("MoreData").getProperty("master");
		Schema viaPath = model.getPath("/sampledatamanagement/v1/sampledata/custom/{id}").getGet().getResponse("200")
				.getContentMediaType("application/json").getSchema();
		assertTrue(direct == viaMoreData);
		assertTrue(direct == viaPath);
	}
}
