package com.github.shaching.example.presentation.api.v1;

import com.github.shaching.example.application.ExampleService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/example")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleAPI {

    private final ExampleService exampleService;

    @Inject
    public ExampleAPI(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GET
    public Response doSomething() {
        this.exampleService.insert();
        return Response.ok().build();
    }
}
