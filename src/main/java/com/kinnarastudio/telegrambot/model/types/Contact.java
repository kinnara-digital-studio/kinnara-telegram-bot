package com.kinnarastudio.telegrambot.model.types;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @see <a href="https://core.telegram.org/bots/api#contact">Contact</a>
 */
public class Contact extends TelegramType {
    private int userId;
    private String phoneNumber;
    private String firstName;
    private String lastName;

    public Contact(JSONObject json) throws JSONException {
        userId = json.getInt("user_id");
        phoneNumber = json.getString("phone_number");
        firstName = json.getString("first_name");
        lastName = json.getString("last_name");
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("user_id", userId);
        json.put("phone_number", phoneNumber);
        json.put("first_name", firstName);
        json.put("last_name", lastName);
        return json;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
