package com.github.shaching.example.domain;

import com.github.shaching.example.infrastructure.Redis;

import javax.inject.Inject;

public class RedisService {

    private Redis redis;

    @Inject
    public RedisService(Redis redis) {
        this.redis = redis;
    }
}
