package com.kinnarastudio.telegrambot.model.types;

/**
 * Keyboard button for requesting location
 */
public class RequestLocationKeyboardButton extends KeyboardButton {
    public RequestLocationKeyboardButton(String text) {
        super(text);
        setRequestLocation(true);
    }
}
