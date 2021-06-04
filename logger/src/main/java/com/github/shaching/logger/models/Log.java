package com.github.shaching.logger.models;

import java.io.Serializable;
import java.util.LinkedHashMap;

public final class Log implements Serializable {
    private LinkedHashMap<String, Object> map;

    public Log() {
        this.map = new LinkedHashMap<>();
    }

    public LinkedHashMap<String, Object> getMap() {
        return map;
    }

    public static final class Builder {
        private LinkedHashMap<String, Object> map;

        private Builder() {
            this.map = new LinkedHashMap<>();
        }

        public static Builder instance() {
            return new Builder();
        }

        public Builder setMsg(Object value) {
            this.map.put("Msg", value);
            return this;
        }

        public Builder setKV(String key, Object value) {
            this.map.put(key, value);
            return this;
        }

        public Log build() {
            Log log = new Log();
            log.map.putAll(this.map);
            return log;
        }
    }
}
