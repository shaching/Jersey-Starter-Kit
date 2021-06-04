package com.github.shaching.errorcode;


import com.github.shaching.logger.models.ILogger;
import com.github.shaching.logger.models.Log;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Arrays;

@Provider
public class UncaughtException extends Throwable implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable exception) {
        int statusCode = this.filter(exception).getStatusCode();
        String errorCode = this.filter(exception).getErrorCode();

        ILogger.error(Log.Builder.instance()
                .setMsg(exception.getMessage())
                .setKV("StatusCode", statusCode)
                .setKV("ErrorCode", errorCode)
                .setKV("Event", exception.toString())
                .setKV("StackTrace", Arrays.toString(exception.getStackTrace()))
                .build()
        );

        return Response
                .status(statusCode)
                .entity(errorCode)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private HttpErrorCode filter(Throwable exception) {
        // instanceof here
        return HttpErrorCode.INTERNAL_SERVER_ERROR;
    }
}
