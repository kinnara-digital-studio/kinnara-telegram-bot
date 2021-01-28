package com.kinnarastudio.telegrambot.model.types;

import com.kinnarastudio.commons.Try;
import com.kinnarastudio.commons.jsonstream.JSONCollectors;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Model for inline keyboards
 */
public class InlineKeyboardButtons extends TelegramCollectionType {
    private final List<List<InlineKeyboardButton>> inlineKeyboards;

    public InlineKeyboardButtons() {
        inlineKeyboards = new ArrayList<>();
    }

    public void addInlineKeyboard(InlineKeyboardButton inlineKeyboardButton) {
        inlineKeyboards.add(Collections.singletonList(inlineKeyboardButton));
    }

    public void addInlineKeyboards(Collection<InlineKeyboardButton> inlineKeyboardButtonCollection) {
        inlineKeyboardButtonCollection.forEach(this::addInlineKeyboard);
    }

    public List<InlineKeyboardButton> getFlattenedInlineKeyboards() {
        return inlineKeyboards.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public JSONArray toJson() {
        return inlineKeyboards.stream()
                .map(l -> l.stream()
                        .map(Try.onFunction(InlineKeyboardButton::toJson))
                        .collect(JSONCollectors.toJSONArray()))
                .collect(JSONCollectors.toJSONArray());
    }

    public static void combine(InlineKeyboardButtons buttons1, InlineKeyboardButtons buttons2) {
        buttons1.addInlineKeyboards(buttons2.getFlattenedInlineKeyboards());
    }
}
