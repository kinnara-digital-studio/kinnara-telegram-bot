package com.kinnarastudio.telegrambot.model.types;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @see <a href="https://core.telegram.org/bots/api#inlinekeyboardbutton">InlineKeyboardButton</a>
 */
public class InlineKeyboardButton extends TelegramType {
    private String text;
    private String url;
    private String callbackData;
    private String loginUrl;

    public InlineKeyboardButton(JSONObject json) throws JSONException {
        text = json.getString("text");
        url = json.getString("url");
        callbackData = json.getString("callback_data");
        loginUrl = json.getString("login_url");
    }

    public InlineKeyboardButton(String text, String callbackData) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("text", text);
        json.put("url", url);
        json.put("callback_data", callbackData);
        json.put("login_url", loginUrl);
        return json;
    }
}
