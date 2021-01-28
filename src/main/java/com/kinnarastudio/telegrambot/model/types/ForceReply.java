package com.kinnarastudio.telegrambot.model.types;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * See <a href="https://core.telegram.org/bots/api#forcereply">Force Reply</a>
 */
public class ForceReply extends ReplyMarkup {
    private final boolean forceReply;
    private boolean selective;

    public ForceReply() {
        this.forceReply = true;
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("force_reply", true);
        jsonObject.put("selective", selective);
        return jsonObject;
    }

    public boolean isSelective() {
        return selective;
    }

    public void setSelective(boolean selective) {
        this.selective = selective;
    }
}
