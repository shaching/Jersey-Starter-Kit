package com.github.shaching.logger.models;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Instant;

public interface ILogger extends IGson {
    String LOG_LEVEL = System.getenv("LOG_LEVEL");
    String HOST_NAME = System.getenv("HOST_NAME");

    String KEY_HOST_NAME = "HostName";
    String KEY_TIME = "Time";
    String KEY_LEVEL = "Level";

    Logger LOG4J2 = LogManager.getLogger();

    void Debug(Log log);

    void Info(Log log);

    void Warn(Log log);

    void Error(Log log);

    static void debug(Object msg) {
        debug(Log.Builder.instance().setMsg(msg).build());
    }

    static void debug(Log log) {
        if (Level.INFO.toString().equalsIgnoreCase(LOG_LEVEL)) {
            return;
        }

        if (Level.WARN.toString().equalsIgnoreCase(LOG_LEVEL)) {
            return;
        }

        if (Level.ERROR.toString().equalsIgnoreCase(LOG_LEVEL)) {
            return;
        }

        Log temp = Log.Builder.instance()
                .setKV(KEY_HOST_NAME, HOST_NAME)
                .setKV(KEY_LEVEL, Level.DEBUG.toString())
                .setKV(KEY_TIME, Instant.now().toString())
                .build();

        temp.getMap().putAll(log.getMap());

        LOG4J2.debug(GSON.toJson(temp.getMap()));
    }

    static void info(Object msg) {
        info(Log.Builder.instance().setMsg(msg).build());
    }

    static void info(Log log) {
        if (Level.WARN.toString().equalsIgnoreCase(LOG_LEVEL)) {
            return;
        }

        if (Level.ERROR.toString().equalsIgnoreCase(LOG_LEVEL)) {
            return;
        }

        Log temp = Log.Builder.instance()
                .setKV(KEY_HOST_NAME, HOST_NAME)
                .setKV(KEY_LEVEL, Level.INFO.toString())
                .setKV(KEY_TIME, Instant.now().toString())
                .build();

        temp.getMap().putAll(log.getMap());

        LOG4J2.info(GSON.toJson(temp.getMap()));
    }

    static void warn(Object msg) {
        warn(Log.Builder.instance().setMsg(msg).build());
    }

    static void warn(Log log) {
        if (Level.ERROR.toString().equalsIgnoreCase(LOG_LEVEL)) {
            return;
        }

        Log temp = Log.Builder.instance()
                .setKV(KEY_HOST_NAME, HOST_NAME)
                .setKV(KEY_LEVEL, Level.WARN.toString())
                .setKV(KEY_TIME, Instant.now().toString())
                .build();

        temp.getMap().putAll(log.getMap());

        LOG4J2.warn(GSON.toJson(temp.getMap()));
    }

    static void error(Object msg) {
        error(Log.Builder.instance().setMsg(msg).build());
    }

    static void error(Log log) {
        Log temp = Log.Builder.instance()
                .setKV(KEY_HOST_NAME, HOST_NAME)
                .setKV(KEY_LEVEL, Level.ERROR.toString())
                .setKV(KEY_TIME, Instant.now().toString())
                .build();

        temp.getMap().putAll(log.getMap());

        LOG4J2.error(GSON.toJson(temp.getMap()));
    }
}
