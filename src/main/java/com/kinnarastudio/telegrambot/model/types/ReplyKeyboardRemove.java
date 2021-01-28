package com.kinnarastudio.telegrambot.model.types;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Remove from telegram {@link ReplyKeyboardMarkup}
 */
public class ReplyKeyboardRemove extends ReplyMarkup {
    private boolean removeKeyboard;
    private boolean selective;

    public ReplyKeyboardRemove() {
        removeKeyboard = true;
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("remove_keyboard", removeKeyboard);
        jsonObject.put("selective", selective);
        return jsonObject;
    }


    public boolean isRemoveKeyboard() {
        return removeKeyboard;
    }

    public void setRemoveKeyboard(boolean removeKeyboard) {
        this.removeKeyboard = removeKeyboard;
    }

    public boolean isSelective() {
        return selective;
    }

    public void setSelective(boolean selective) {
        this.selective = selective;
    }
}
