package com.github.shaching;

import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

import javax.ws.rs.core.UriBuilder;

public class Standalone {
    public static void main(String[] args) {

        String port = System.getenv("PORT");

        JettyHttpContainerFactory.createServer(
                UriBuilder
                        .fromUri("http://0.0.0.0/")
                        .port(StringUtils.isBlank(port) ? 8080 : Integer.parseInt(port))
                        .build(),
                new JerseyResourceConfig()
        );
    }
}
