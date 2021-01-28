package com.kinnarastudio.telegrambot.model.types;

import com.kinnarastudio.telegrambot.exception.TelegramException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * See <a href="https://core.telegram.org/bots/api#inlinequery">InlineQuery</a>
 */
public class InlineQuery extends TelegramType implements TelegramResponse{
    private final int id;
    private User from;
    private Location location;
    private String query;
    private String offset;

    public InlineQuery(JSONObject jsonObject) throws TelegramException {
        try {
            id = jsonObject.getInt("id");
        } catch (JSONException e) {
            throw new TelegramException(e);
        }

        try {
            from = new User(jsonObject.getJSONObject("from"));
        } catch (JSONException ignored) { }

        try {
            location = new Location(jsonObject.getJSONObject("location"));
        } catch (JSONException ignored) { }

        try {
            query = jsonObject.getString("query");
        } catch (JSONException ignored) { }

        try {
            offset = jsonObject.getString("offset");
        } catch (JSONException ignored) { }
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("from", from);
        jsonObject.put("location", location);
        jsonObject.put("query", query);
        jsonObject.put("offset", offset);
        return jsonObject;
    }
}
