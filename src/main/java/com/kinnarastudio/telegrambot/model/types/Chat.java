package com.kinnarastudio.telegrambot.model.types;

import com.kinnarastudio.telegrambot.exception.TelegramException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * See <a href="https://core.telegram.org/bots/api#chat">Chat</a>
 */
public class Chat extends TelegramType {
    private final int id;
    private final String type;
    private String firstName;
    private String lastName;
    private String username;

    public Chat(JSONObject json) throws TelegramException {
        try {
            id = json.getInt("id");
        } catch (JSONException e) {
            throw new TelegramException(e);
        }

        try {
            type = json.getString("type");
        } catch (JSONException e) {
            throw new TelegramException(e);
        }

        try {
            firstName = json.getString("first_name");
        } catch (JSONException ignored) { }

        try {
            lastName = json.getString("last_name");
        } catch (JSONException ignored) { }

        try {
            username = json.getString("username");
        } catch (JSONException ignored) { }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("first_name", firstName);
        json.put("last_name", lastName);
        json.put("username", username);
        json.put("type", type);
        return json;
    }
}
