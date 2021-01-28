package com.kinnarastudio.telegrambot.model.types;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Level;
import java.util.logging.Logger;

//public abstract class TelegramType implements ToJson<JSONObject> {
public abstract class TelegramType {
    @Override
    public String toString() {
        try {
            return toJson().toString();
        } catch (JSONException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e.getMessage());
            return null;
        }
    }

    public abstract JSONObject toJson() throws JSONException ;
}
