package com.github.shaching;

import com.github.shaching.example.domain.MongoDBService;
import com.github.shaching.example.domain.MySQLService;
import com.github.shaching.example.domain.RedisService;
import com.github.shaching.example.infrastructure.MongoDB;
import com.github.shaching.example.infrastructure.MySQL;
import com.github.shaching.example.infrastructure.Redis;
import com.github.shaching.example.presentation.api.v1.ExampleAPI;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

public final class JerseyBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bindAsContract(ExampleAPI.class).in(Singleton.class);
        bindAsContract(MongoDBService.class).in(Singleton.class);
        bindAsContract(MySQLService.class).in(Singleton.class);
        bindAsContract(RedisService.class).in(Singleton.class);
        bindAsContract(MongoDB.class).in(Singleton.class);
        bindAsContract(MySQL.class).in(Singleton.class);
        bindAsContract(Redis.class).in(Singleton.class);
    }
}
