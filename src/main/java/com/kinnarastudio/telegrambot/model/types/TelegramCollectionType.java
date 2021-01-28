package com.kinnarastudio.telegrambot.model.types;

import org.json.JSONArray;

public abstract class TelegramCollectionType {
    @Override
    public String toString() {
        return toJson().toString();
    }

    public abstract JSONArray toJson();
}
