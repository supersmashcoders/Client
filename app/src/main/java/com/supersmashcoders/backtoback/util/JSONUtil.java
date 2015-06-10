package com.supersmashcoders.backtoback.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtil {
    public static JSONArray getArrayOrEmpty(JSONObject source, String arrayName) {
        try {
            return source.getJSONArray(arrayName);
        } catch (JSONException e) {
            return new JSONArray();
        }
    }
}
