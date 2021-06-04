package com.github.shaching.example.domain;

import com.github.shaching.example.infrastructure.MySQL;

import javax.inject.Inject;

public class MySQLService {

    private MySQL mySQL;

    @Inject
    public MySQLService(MySQL mySQL) {
        this.mySQL = mySQL;
    }
}
