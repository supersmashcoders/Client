package com.supersmashcoders.backtoback.models;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageEntity {
    private Long id;
    private String servingURL;

    private ImageEntity(Long id, String servingURL) {
        this.id = id;
        this.servingURL = servingURL;
    }

    public static ImageEntity of(Long id, String servingURL) {
        return new ImageEntity(id, servingURL);
    }

    public static ImageEntity of(JSONObject jsonImage) {
        try {
            Long id = jsonImage.getLong("id");
            String servingUrl = jsonImage.getString("servingUrl");
            return new ImageEntity(id, servingUrl);
        } catch (JSONException e) {
            Log.e("JSON PARSE", "ERROR PARSING " + jsonImage.toString());
            return null;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServingURL() {
        return servingURL;
    }

    public void setServingURL(String servingURL) {
        this.servingURL = servingURL;
    }
}
