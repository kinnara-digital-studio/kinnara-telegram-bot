package com.kinnarastudio.telegrambot.model.types;

public class TelegramClient {
    private final Update update;

    public TelegramClient() {
        this.update = null;
    }

    public TelegramClient(Update update) {
        this.update = update;
    }

    public Update getUpdate() {
        return update;
    }
}
