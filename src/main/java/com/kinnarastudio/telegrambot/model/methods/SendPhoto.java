package com.kinnarastudio.telegrambot.model.methods;

import com.kinnarastudio.commons.Try;
import com.kinnarastudio.commons.jsonstream.JSONCollectors;
import com.kinnarastudio.telegrambot.model.types.MessageEntity;
import com.kinnarastudio.telegrambot.model.types.ReplyMarkup;
import com.kinnarastudio.telegrambot.model.types.TelegramRequest;
import com.kinnarastudio.telegrambot.model.types.TelegramType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * See <a href="https://core.telegram.org/bots/api#sendphoto">sendPhoto</a>
 */
public class SendPhoto extends TelegramType implements TelegramRequest {
    private final int chatId;
    private String photo;
    private String caption;
    private String parseMode;
    private Collection<MessageEntity> captionEntities;
    private int replyToMessageId;
    private boolean allowSendingWithoutReply;
    private ReplyMarkup replyMarkup;

    public SendPhoto(int chatId) {
        this.chatId = chatId;
    }

    @Override
    public String getMethod() {
        return "sendPhoto";
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("chat_id", chatId);
        json.put("photo", photo);
        json.put("caption", caption);
        json.put("parse_mode", parseMode);

        JSONArray jsonCaptionEntities = Optional.ofNullable(captionEntities)
                .map(Collection::stream)
                .orElseGet(Stream::empty)
                .map(Try.onFunction(MessageEntity::toJson))
                .collect(JSONCollectors.toJSONArray());

        json.put("caption_entities", jsonCaptionEntities);

        json.put("reply_to_message_id", replyToMessageId);

        json.put("allow_sending_without_reply", allowSendingWithoutReply);

        json.put("reply_markup", replyMarkup);

        return json;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getParseMode() {
        return parseMode;
    }

    public void setParseMode(String parseMode) {
        this.parseMode = parseMode;
    }

    public Collection<MessageEntity> getCaptionEntities() {
        return captionEntities;
    }

    public void setCaptionEntities(Collection<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
    }

    public int getReplyToMessageId() {
        return replyToMessageId;
    }

    public void setReplyToMessageId(int replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
    }

    public ReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    public boolean getAllowSendingWithoutReply() {
        return allowSendingWithoutReply;
    }

    public void setAllowSendingWithoutReply(boolean allowSendingWithoutReply) {
        this.allowSendingWithoutReply = allowSendingWithoutReply;
    }
}
