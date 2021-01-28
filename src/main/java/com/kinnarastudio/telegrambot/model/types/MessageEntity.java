package com.kinnarastudio.telegrambot.model.types;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * See <a href="https://core.telegram.org/bots/api#messageentity">Message Entity</a>
 */
public class MessageEntity extends TelegramType {
    private String type;

    public MessageEntity(JSONObject json) throws JSONException {
        type = json.getString("type");
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("type", type);
        return json;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
