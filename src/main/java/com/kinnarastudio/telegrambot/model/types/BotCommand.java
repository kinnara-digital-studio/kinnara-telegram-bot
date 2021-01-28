package com.kinnarastudio.telegrambot.model.types;

import com.kinnarastudio.telegrambot.exception.TelegramException;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

/**
 * @see <a href="https://core.telegram.org/bots/api#botcommand">BotCommand</a>
 */
public class BotCommand extends TelegramType {
    public final static Pattern patternCommand = Pattern.compile("[a-z0-9_]{1,32}");
    public final static Pattern patternDescription = Pattern.compile(".{3,256}");

    private final String command;
    private final String description;

    public BotCommand(String command, String description) throws TelegramException {
        if(!patternCommand.matcher(command).matches()) {
            throw new TelegramException("Invalid command [" + command + "] : Text of the command, 1-32 characters. Can contain only lowercase English letters, digits and underscores.");
        }

        if(!patternDescription.matcher(description).matches()) {
            throw new TelegramException("Invalid description [" + description + "]: Description of the command, 3-256 characters.");
        }

        this.command = command;
        this.description = description;
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("command", command);
        jsonObject.put("description", description);
        return jsonObject;
    }

    public String getDescription() {
        return description;
    }

    public String getCommand() {
        return command;
    }
}
