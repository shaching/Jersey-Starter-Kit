package com.github.shaching.errorcode;

import javax.ws.rs.core.Response;

public enum HttpErrorCode {
    INTERNAL_SERVER_ERROR(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "10000"),
    EXAMPLE_ERROR(Response.Status.BAD_REQUEST.getStatusCode(), "10001"),
    ;

    private final int statusCode;
    private final String errorCode;

    HttpErrorCode(int statusCode, String errorCode) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
