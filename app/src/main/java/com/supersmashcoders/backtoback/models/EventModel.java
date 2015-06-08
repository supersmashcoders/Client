package com.supersmashcoders.backtoback.models;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class EventModel {
    private long id;
    private String title;
    private String body;

    private EventModel(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public static EventModel of(long id, String title, String body) {
        return new EventModel(id, title, body);
    }

    public static EventModel of(JSONObject jsonObject) {
        try {
            long id = jsonObject.getLong("id");
            String title = jsonObject.getString("title");
            String body = jsonObject.getString("body");
            return new EventModel(id, title, body);
        } catch(JSONException e) {
            Log.e("JSON PARSE", "Failed to parse json object " + jsonObject.toString());
        }
        return null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
