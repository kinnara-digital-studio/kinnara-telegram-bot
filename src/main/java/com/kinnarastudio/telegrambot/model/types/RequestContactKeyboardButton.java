package com.kinnarastudio.telegrambot.model.types;

/**
 * Keyboard button for requesting contact
 */
public class RequestContactKeyboardButton extends KeyboardButton {
    public RequestContactKeyboardButton(String text) {
        super(text);
        setRequestContact(true);
    }
}
