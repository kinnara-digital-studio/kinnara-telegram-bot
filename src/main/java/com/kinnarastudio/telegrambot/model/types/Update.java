package com.kinnarastudio.telegrambot.model.types;

import com.kinnarastudio.commons.Try;
import com.kinnarastudio.telegrambot.exception.TelegramException;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Optional;

/**
 * See <a href="https://core.telegram.org/bots/api#getting-updates">Update</a>
 */
public class Update extends TelegramType implements TelegramResponse {
    private int updateId;
    private Message message;
    private InlineQuery inline_query;
    private CallbackQuery callbackQuery;

    public Update(JSONObject json) throws TelegramException {
        try {
            updateId = json.getInt("update_id");
        } catch (JSONException ignored) { }

        try {
            message = new Message(json.getJSONObject("message"));
        } catch (JSONException ignored) { }

        try {
            inline_query = new InlineQuery(json.getJSONObject("inline_query"));
        } catch (JSONException ignored) { }

        try {
            callbackQuery = new CallbackQuery(json.getJSONObject("callback_query"));
        } catch (JSONException ignored) { }
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("update_id", updateId);
        json.put("message", Optional.ofNullable(message).map(Try.onFunction(Message::toJson)).orElse(null));
        json.put("callback_query", Optional.ofNullable(callbackQuery).map(Try.onFunction(CallbackQuery::toJson)).orElse(null));
        return json;
    }

    public int getUpdateId() {
        return updateId;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public CallbackQuery getCallbackQuery() {
        return callbackQuery;
    }

    public void setCallbackQuery(CallbackQuery callbackQuery) {
        this.callbackQuery = callbackQuery;
    }
}
