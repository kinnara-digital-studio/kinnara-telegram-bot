package com.kinnarastudio.telegrambot.model.types;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @see <a href="https://core.telegram.org/bots/api#deletemessage">deleteMessage</a>
 */
public class DeleteMessage extends TelegramType implements TelegramRequest {
    private final int chatId;
    private final int messageId;

    public DeleteMessage(int chatId, int messageId) {
        this.chatId = chatId;
        this.messageId = messageId;
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("chat_id", chatId);
        json.put("message_id", messageId);
        return json;
    }

    @Override
    public String getMethod() {
        return "deleteMessage";
    }
}
