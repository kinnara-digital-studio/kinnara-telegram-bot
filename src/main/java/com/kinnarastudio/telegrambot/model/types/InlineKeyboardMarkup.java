package com.kinnarastudio.telegrambot.model.types;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Optional;

/**
 * @see <a href="https://core.telegram.org/bots/api#inlinekeyboardmarkup">InlineKeyboardMarkup</a>
 */
public class InlineKeyboardMarkup extends ReplyMarkup {
    private InlineKeyboardButtons inlineKeyboards;

    public InlineKeyboardMarkup() { }

    public InlineKeyboardMarkup(JSONObject json) throws JSONException {
        inlineKeyboards = new InlineKeyboardButtons();

        JSONArray jsonInlineKeyboardRow = Optional.ofNullable(json.optJSONArray("inline_keyboard")).orElse(new JSONArray());
        for(int i = 0, sizeI = jsonInlineKeyboardRow.length(); i < sizeI; i++) {
            JSONArray jsonInlineKeyboardColumn = Optional.ofNullable(jsonInlineKeyboardRow.optJSONArray(i)).orElse(new JSONArray());
            for(int j = 0, sizeJ = jsonInlineKeyboardColumn.length(); j < sizeJ; j++) {
                JSONObject jsonInlineKeyboardButton = jsonInlineKeyboardColumn.getJSONObject(j);
                inlineKeyboards.addInlineKeyboard(new InlineKeyboardButton(jsonInlineKeyboardButton));
            }
        }
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("inline_keyboard", inlineKeyboards.toJson());
        return json;
    }

    public InlineKeyboardButtons getInlineKeyboards() {
        return inlineKeyboards;
    }

    public void setInlineKeyboards(InlineKeyboardButtons inlineKeyboards) {
        this.inlineKeyboards = inlineKeyboards;
    }
}
