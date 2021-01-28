package com.kinnarastudio.telegrambot.model.types;

import com.kinnarastudio.telegrambot.exception.TelegramException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * See <a href="https://core.telegram.org/bots/api#location">Location</a>
 */
public class Location extends TelegramType implements TelegramResponse {
    private final double longitude;
    private final double latitude;

    private double horizontalAccuracy;
    private int livePeriod;
    private int heading;
    private int proximityAlertRadius;

    public Location(JSONObject json) throws TelegramException {
        try {
            longitude = json.getDouble("longitude");
            latitude = json.getDouble("latitude");
        } catch (JSONException e) {
            throw new TelegramException(e);
        }

        try {
            horizontalAccuracy = json.getInt("horizontal_accuracy");
        } catch (JSONException ignored) { }

        try {
            livePeriod = json.getInt("live_period");
        } catch (JSONException ignored) { }

        try {
            heading = json.getInt("heading");
        } catch (JSONException ignored) { }

        try {
            proximityAlertRadius = json.getInt("proximity_alert_radius");
        } catch (JSONException ignored) { }
    }

    @Override
    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("longitude", longitude);
        json.put("latitude", latitude);
        json.put("horizontal_accuracy", horizontalAccuracy);
        json.put("live_period", livePeriod);
        json.put("heading", heading);
        json.put("proximity_alert_radius", proximityAlertRadius);
        return json;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getHorizontalAccuracy() {
        return horizontalAccuracy;
    }

    public int getLivePeriod() {
        return livePeriod;
    }

    public int getHeading() {
        return heading;
    }

    public int getProximityAlertRadius() {
        return proximityAlertRadius;
    }
}
