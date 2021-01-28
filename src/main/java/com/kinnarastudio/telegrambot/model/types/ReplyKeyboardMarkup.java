package com.kinnarastudio.telegrambot.model.types;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @see <a href="https://core.telegram.org/bots/api#replykeyboardmarkup">ReplyKeyboardMarkup</a>
 */
public class ReplyKeyboardMarkup extends ReplyMarkup {
    private KeyboardButtons keyboards;
    private boolean resizeKeyboard;
    private boolean oneTimeKeyboard;
    private boolean selective;

    public ReplyKeyboardMarkup() {
        keyboards = new KeyboardButtons();
        this.setResizeKeyboard(true);
        this.setOneTimeKeyboard(true);
    }

    public KeyboardButtons getKeyboards() {
        return keyboards;
    }

    public void setKeyboards(KeyboardButtons keyboards) {
        this.keyboards = keyboards;
    }

    public boolean isResizeKeyboard() {
        return resizeKeyboard;
    }

    public void setResizeKeyboard(boolean resizeKeyboard) {
        this.resizeKeyboard = resizeKeyboard;
    }

    public boolean isOneTimeKeyboard() {
        return oneTimeKeyboard;
    }

    public void setOneTimeKeyboard(boolean oneTimeKeyboard) {
        this.oneTimeKeyboard = oneTimeKeyboard;
    }

    public boolean isSelective() {
        return selective;
    }

    public void setSelective(boolean selective) {
        this.selective = selective;
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("keyboard", keyboards.toJson());
        json.put("resize_keyboard", resizeKeyboard);
        json.put("one_time_keyboard", oneTimeKeyboard);
        json.put("selective", selective);
        return json;
    }
}
