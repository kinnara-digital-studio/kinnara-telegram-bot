package com.kinnarastudio.telegrambot.model.types;

import com.kinnarastudio.commons.Try;
import com.kinnarastudio.telegrambot.exception.TelegramException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * See <a href="https://core.telegram.org/bots/api#message>Message</>
 */
public class Message extends TelegramType implements TelegramResponse {
    private final int messageId;
    private User from;
    private final int date;
    private final Chat chat;
    private String text;
    private Contact contact;
    private Location location;
    private InlineKeyboardMarkup replyMarkup;
    private List<MessageEntity> entities;

    public Message(JSONObject json) throws TelegramException {
        try {
            messageId = json.getInt("message_id");
        } catch (JSONException e) {
            throw new TelegramException(e);
        }

        try {
            from = new User(json.getJSONObject("from"));
        } catch (JSONException ignored) {}

        try {
            date = json.getInt("date");
        } catch (JSONException e) {
            throw new TelegramException(e);
        }

        try {
            chat = new Chat(json.getJSONObject("chat"));
        } catch (JSONException e) {
            throw new TelegramException(e);
        }

        text = json.optString("text");

        try {
            contact = new Contact(json.getJSONObject("contact"));
        } catch (JSONException ignored) {}

        try {
            location = new Location(json.getJSONObject("location"));
        } catch (JSONException ignored) {}

        try {
            replyMarkup = new InlineKeyboardMarkup(json.getJSONObject("reply_markup"));
        } catch (JSONException ignored) {}

        try {
            JSONArray jsonEntities = json.getJSONArray("entities");
            entities = new ArrayList<>();
            for(int i = 0, size = jsonEntities.length(); i < size; i++) {
                JSONObject jsonEntity = Optional.ofNullable(jsonEntities.optJSONObject(i)).orElse(new JSONObject());
                MessageEntity entity = new MessageEntity(jsonEntity);
                entities.add(entity);
            }
        } catch (JSONException ignored) {}
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("message_id", messageId);
        json.put("from", Optional.ofNullable(from).map(Try.onFunction(User::toJson)).orElse(null));
        json.put("date", date);
        json.put("chat", Optional.ofNullable(chat).map(Try.onFunction(Chat::toJson)).orElse(null));
        json.put("contact", Optional.ofNullable(contact).map(Try.onFunction(Contact::toJson)).orElse(null));
        json.put("reply_markup", Optional.ofNullable(replyMarkup).map(Try.onFunction(InlineKeyboardMarkup::toJson)).orElse(null));
        return null;
    }

    public int getMessageId() {
        return messageId;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public int getDate() {
        return date;
    }

    public Chat getChat() {
        return chat;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    public List<MessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<MessageEntity> entities) {
        this.entities = entities;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Location getLocation() {
        return location;
    }
}
