package com.github.shaching.logger.application;

import com.github.shaching.logger.models.ILogger;
import com.github.shaching.logger.models.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class ExceptionService {

    @Pointcut("within(com.github.shaching.*)")
    public void root() {
    }

    @AfterThrowing(pointcut = "root()", throwing = "throwable")
    public void handle(JoinPoint joinPoint, Throwable throwable) {
        ILogger.error(Log.Builder.instance()
                .setMsg(throwable.getMessage())
                .setKV("Event", throwable.toString())
                .setKV("StackTrace", Arrays.toString(throwable.getStackTrace()))
                .build()
        );
    }
}
