package com.github.shaching;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public final class JerseyResourceConfig extends ResourceConfig {
    public JerseyResourceConfig() {
        property(ServerProperties.WADL_FEATURE_DISABLE, true);

        register(MultiPartFeature.class);
        register(OpenApiResource.class);
        register(new JerseyBinder());
        packages(
                "io.swagger.v3.jaxrs2.integration.resources",
                "com.github.shaching"
        );
    }
}
