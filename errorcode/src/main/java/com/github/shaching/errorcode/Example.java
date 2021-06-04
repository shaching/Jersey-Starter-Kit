package com.github.shaching.errorcode;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public final class Example extends ErrorCode implements ExceptionMapper<Example> {
    Example() {
        super(HttpErrorCode.EXAMPLE_ERROR.getErrorCode());
    }

    @Override
    public Response toResponse(Example exception) {
        return Response
                .status(HttpErrorCode.EXAMPLE_ERROR.getStatusCode())
                .entity(HttpErrorCode.EXAMPLE_ERROR.getErrorCode())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
