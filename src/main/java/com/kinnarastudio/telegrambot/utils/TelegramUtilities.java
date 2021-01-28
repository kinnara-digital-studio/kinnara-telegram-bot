package com.kinnarastudio.telegrambot.utils;
import com.kinnarastudio.telegrambot.exception.TelegramException;
import com.kinnarastudio.telegrambot.model.methods.SendMessage;
import com.kinnarastudio.telegrambot.model.methods.SendPhoto;
import com.kinnarastudio.telegrambot.model.types.DeleteMessage;
import com.kinnarastudio.telegrambot.model.types.EditMessageText;
import com.kinnarastudio.telegrambot.model.types.ReplyMarkup;
import com.kinnarastudio.telegrambot.model.types.TelegramRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Implement this class
 */
public interface TelegramUtilities {
    /**
     * Send message
     *
     * @param telegramBotToken
     * @param chatId
     * @param message
     */
    default void sendMessage(String telegramBotToken, int chatId, String message) throws TelegramException {
        SendMessage sendMessage = new SendMessage(chatId, message);
        request(telegramBotToken, sendMessage);
    }

    /**
     * Send message with reply keyboard
     *
     * @param telegramBotToken
     * @param chatId
     * @param message
     * @param replyKeyboardMarkup
     */
    default void sendMessage(String telegramBotToken, int chatId, String message, ReplyMarkup replyKeyboardMarkup) throws TelegramException {
        SendMessage sendMessage = new SendMessage(chatId, message);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        request(telegramBotToken, sendMessage);
    }


    default void sendPicture(String telegramBotToken, int chatId, String imageUrl, String caption) throws TelegramException {
        SendPhoto sendPhoto = new SendPhoto(chatId);
        sendPhoto.setPhoto(imageUrl);
        sendPhoto.setCaption(caption);
        request(telegramBotToken, sendPhoto);
    }

    /**
     * Gelete message
     *
     * @param telegramBotToken
     * @param chatId
     * @param messageId
     */
    default void deleteMessage(String telegramBotToken, int chatId, int messageId) throws TelegramException {
        DeleteMessage deleteMessage = new DeleteMessage(chatId, messageId);
        request(telegramBotToken, deleteMessage);
    }


    /**
     * Edit message
     *
     * @param telegramBotToken
     * @param charId
     * @param messageId
     * @param newText
     */
    default void editMessage(String telegramBotToken, int charId, int messageId, String newText) throws TelegramException {
        EditMessageText editMessageText = new EditMessageText(charId, messageId, newText);
        request(telegramBotToken, editMessageText);
    }


    /**
     * Request to telegram bot API
     *
     * @param telegramBotToken
     * @param request
     */
    default void request(String telegramBotToken, TelegramRequest request) throws TelegramException {
        request(telegramBotToken, request, false);
    }


    /**
     * Request to telegram bot API
     *
     * @param telegramBotToken
     * @param request
     * @param debug
     */
    default void request(String telegramBotToken, TelegramRequest request, boolean debug) throws TelegramException {
        try {
            HttpPost post = new HttpPost("https://api.telegram.org/bot" + telegramBotToken + "/" + request.getMethod());
            post.addHeader("Content-Type", "application/json");
            post.setEntity(new StringEntity(request.toString()));

            try (CloseableHttpClient client = HttpClientBuilder.create().build();
                 CloseableHttpResponse botResponse = client.execute(post);
                 BufferedReader br = new BufferedReader(new InputStreamReader(botResponse.getEntity().getContent()))) {

                int statusCode = botResponse.getStatusLine().getStatusCode();
                String responsePayload = br.lines().collect(Collectors.joining());
                if(statusCode != 200) {
                    throw new TelegramException(responsePayload);
                }
            }
        } catch (IOException e) {
            throw new TelegramException(e);
        }
    }
}
