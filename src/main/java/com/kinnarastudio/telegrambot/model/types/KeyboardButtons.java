package com.kinnarastudio.telegrambot.model.types;

import com.kinnarastudio.commons.Try;
import com.kinnarastudio.commons.jsonstream.JSONCollectors;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KeyboardButtons extends TelegramCollectionType {
    private List<List<KeyboardButton>> keyboards;

    public KeyboardButtons() {
        keyboards = new ArrayList<>();
    }

    public void addKeyboardButton(KeyboardButton keyboardButton) {
        keyboards.add(Collections.singletonList(keyboardButton));
    }

    public void addKeyboardButtons(Collection<KeyboardButton> keyboards) {
        keyboards.forEach(this::addKeyboardButton);
    }

    public List<KeyboardButton> getFlattenedKeyboards() {
        return keyboards.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public JSONArray toJson() {
        return keyboards.stream()
                .map(l -> l.stream()
                        .map(Try.onFunction(KeyboardButton::toJson))
                        .collect(JSONCollectors.toJSONArray())
                )
                .collect(JSONCollectors.toJSONArray());
    }
}
