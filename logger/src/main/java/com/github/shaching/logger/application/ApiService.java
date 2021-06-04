package com.github.shaching.logger.application;

import com.github.shaching.logger.models.ILogger;
import com.github.shaching.logger.models.Log;
import org.glassfish.jersey.logging.LoggingFeature;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.HEADER_DECORATOR)
public class ApiService extends LoggingFeature implements ContainerRequestFilter, ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        ILogger.info(Log.Builder.instance()
                .setMsg("Request")
                .setKV("Method", requestContext.getMethod())
                .setKV("API", requestContext.getUriInfo().getRequestUri().getPath())
                .setKV("IP", requestContext.getUriInfo().getRequestUri().getHost())
                .setKV("Port", requestContext.getUriInfo().getRequestUri().getPort())
                .setKV("UserAgent", requestContext.getHeaderString(HttpHeaders.USER_AGENT))
                .setKV("Authorization", requestContext.getHeaderString(HttpHeaders.AUTHORIZATION))
                .build()
        );
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        ILogger.info(Log.Builder.instance()
                .setMsg("Response")
                .setKV("Method", requestContext.getMethod())
                .setKV("Status", responseContext.getStatus())
                .setKV("API", requestContext.getUriInfo().getRequestUri().getPath())
                .setKV("IP", requestContext.getUriInfo().getRequestUri().getHost())
                .setKV("Port", requestContext.getUriInfo().getRequestUri().getPort())
                .setKV("UserAgent", requestContext.getHeaderString(HttpHeaders.USER_AGENT))
                .setKV("Authorization", requestContext.getHeaderString(HttpHeaders.AUTHORIZATION))
                .build()
        );
    }
}
