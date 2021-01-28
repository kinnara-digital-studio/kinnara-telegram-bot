package com.kinnarastudio.telegrambot.model.methods;

import com.kinnarastudio.telegrambot.exception.TelegramException;
import com.kinnarastudio.telegrambot.model.types.MessageEntity;
import com.kinnarastudio.telegrambot.model.types.ReplyMarkup;
import com.kinnarastudio.telegrambot.model.types.TelegramRequest;
import com.kinnarastudio.telegrambot.model.types.TelegramType;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.regex.Pattern;

/**
 * See <a href="https://core.telegram.org/bots/api#sendmessage">Send Message</a>
 */
public class SendMessage extends TelegramType implements TelegramRequest {
    public final static Pattern patternText = Pattern.compile(".{1,4096}");

    private final int chatId;
    private final String text;
    private ReplyMarkup replyMarkup;
    private int replyToMessageId;
    private Collection<MessageEntity> entities;

    public SendMessage(int chatId, String text) throws TelegramException {
        this.chatId = chatId;

        if(!patternText.matcher(text).matches()) {
            throw new TelegramException("text : Text of the message to be sent, 1-4096 characters after entities parsing");
        }
        this.text = text;
    }

    public SendMessage(int chatId, String text, int replyToMessageId) throws TelegramException {
        this(chatId, text);
        this.replyToMessageId = replyToMessageId;
    }

    public int getChatId() {
        return chatId;
    }

    public String getText() {
        return text;
    }

    public ReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("chat_id", chatId);
        json.put("text", text);
        json.put("reply_to_message_id", replyToMessageId);
        json.put("reply_markup", replyMarkup == null ? null : replyMarkup.toJson());
        return json;
    }

    @Override
    public String getMethod() {
        return "sendMessage";
    }

    public Collection<MessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(Collection<MessageEntity> entities) {
        this.entities = entities;
    }
}
