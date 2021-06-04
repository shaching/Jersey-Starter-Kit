package com.github.shaching.example.domain;

import com.github.shaching.example.infrastructure.MongoDB;

import javax.inject.Inject;

public class MongoDBService {

    private MongoDB mongoDB;

    @Inject
    public MongoDBService(MongoDB mongoDB) {
        this.mongoDB = mongoDB;
    }

    public void insert() {

    }
}
