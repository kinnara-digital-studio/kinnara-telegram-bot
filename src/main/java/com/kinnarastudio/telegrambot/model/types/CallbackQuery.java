package com.kinnarastudio.telegrambot.model.types;

import com.kinnarastudio.commons.Try;
import com.kinnarastudio.telegrambot.exception.TelegramException;
import org.json.JSONException;
import org.json.JSONObject;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * See <a href="https://core.telegram.org/bots/api#callbackquery">CallbackQuery</a>
 */
public class CallbackQuery extends TelegramType implements TelegramResponse {
    private String chatId;
    private final User from;
    private Message message;
    private String inlineMessageId;
    private String data;

    public CallbackQuery(@Nonnull JSONObject json) throws TelegramException {
        try {
            chatId = json.getString("chat_id");
        } catch (JSONException ignored) {
        }

        try {
            from = new User(json.getJSONObject("from"));
        } catch (JSONException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "json [" + json.toString() + "]");
            throw new TelegramException(e);
        }

        try {
            message = new Message(json.getJSONObject("message"));
        } catch (JSONException ignored) {
        }

        try {
            inlineMessageId = json.getString("inline_message_id");
        } catch (JSONException ignored) {
        }

        try {
            data = json.getString("data");
        } catch (JSONException ignored) {
        }
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("chat_id", chatId);
        json.put("from", Optional.ofNullable(from).map(Try.onFunction(TelegramType::toJson)).orElse(null));
        json.put("message", Optional.ofNullable(message).map(Try.onFunction(TelegramType::toJson)).orElse(null));
        json.put("inline_message_id", inlineMessageId);
        json.put("data", data);
        return json;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public User getFrom() {
        return from;
    }

    public String getChatId() {
        return chatId;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public void setInlineMessageId(String inlineMessageId) {
        this.inlineMessageId = inlineMessageId;
    }
}
