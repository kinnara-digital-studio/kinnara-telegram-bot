package com.kinnarastudio.telegrambot.model.types;

import com.kinnarastudio.telegrambot.exception.TelegramException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @see <a href="https://core.telegram.org/bots/api#user>User</>
 */
public class User extends TelegramType implements TelegramResponse {
    private int id;
    private boolean isBot;
    private String firstName;
    private String lastName;
    private String username;

    public User(JSONObject json) throws TelegramException {
        try {
            id = json.getInt("id");
        } catch (JSONException e) {
            throw new TelegramException(e);
        }

        isBot = json.optBoolean("is_bot");
        firstName = json.optString("first_name");
        lastName = json.optString("last_name");
        username = json.optString("username");
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("is_bot", isBot);
        json.put("first_name", firstName);
        json.put("last_name", lastName);
        json.put("username", username);
        return json;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBot() {
        return isBot;
    }

    public void setBot(boolean bot) {
        isBot = bot;
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
}
