package com.github.shaching.logger.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public interface IGson {
    Gson GSON = new GsonBuilder().create();
    Gson GSON_PRETTY = new GsonBuilder().setPrettyPrinting().create();
}
