package com.github.shaching.example.application;

import com.github.shaching.example.domain.MongoDBService;
import com.github.shaching.example.domain.MySQLService;
import com.github.shaching.example.domain.RedisService;

import javax.inject.Inject;

public class ExampleService {

    private final MongoDBService mongoDBService;

    private final MySQLService mySQLService;

    private final RedisService redisService;

    @Inject
    public ExampleService(MongoDBService mongoDBService, MySQLService mySQLService, RedisService redisService) {
        this.mongoDBService = mongoDBService;
        this.mySQLService = mySQLService;
        this.redisService = redisService;
    }

    public void insert() {
        this.mongoDBService.insert();
    }
}
