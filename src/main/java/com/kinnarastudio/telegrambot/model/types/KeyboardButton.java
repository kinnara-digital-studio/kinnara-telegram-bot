package com.kinnarastudio.telegrambot.model.types;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @see <a href="https://core.telegram.org/bots/api#keyboardbutton">KeyboardButton</a>
 */
public class KeyboardButton extends TelegramType {
    private final String text;
    private boolean requestContact;
    private boolean requestLocation;

    public KeyboardButton(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public boolean isRequestContact() {
        return requestContact;
    }

    public void setRequestContact(boolean requestContact) {
        this.requestContact = requestContact;
    }

    public boolean isRequestLocation() {
        return requestLocation;
    }

    public void setRequestLocation(boolean requestLocation) {
        this.requestLocation = requestLocation;
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("text", text);

        if(requestContact)
            json.put("request_contact", requestContact);

        if(requestLocation)
            json.put("request_location", requestLocation);
        return json;
    }
}
