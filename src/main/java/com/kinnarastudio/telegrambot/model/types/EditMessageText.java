package com.kinnarastudio.telegrambot.model.types;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @see <a href="https://core.telegram.org/bots/api#editmessagetext">editMessageText</a>
 */
public class EditMessageText extends TelegramType implements TelegramRequest {
    private int chatId;
    private int messageId;
    private String text;
    private String parseMode = "HTML";

    public EditMessageText(int chatId, int messageId, String text) {
        this.chatId = chatId;
        this.messageId = messageId;
        this.text = text;
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("chat_id", chatId);
        json.put("message_id", messageId);
        json.put("text", text);
        json.put("parse_mode", parseMode);
        return json;
    }

    @Override
    public String getMethod() {
        return "editMessageText";
    }
}
