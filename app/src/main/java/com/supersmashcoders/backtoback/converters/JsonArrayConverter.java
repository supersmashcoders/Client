package com.supersmashcoders.backtoback.converters;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class JsonArrayConverter {
    public static <T> List<T> toList(JSONArray jsonArray, Converter<T> converter) {
        List<T> list = new ArrayList<>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                list.add(converter.<T>convert(jsonArray.getJSONObject(i)));
            } catch(JSONException e) {
                Log.e("JSON PARSE", "ERROR PARSING ELEMENT AT POSITION " + i + " OF ARRAY " + jsonArray.toString());
            }
        }
        return list;
    }

    public static List<String> toStringList(JSONArray jsonArray) {
        List<String> list = new ArrayList<>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                list.add(jsonArray.getString(i));
            } catch(JSONException e) {
                Log.e("JSON PARSE", "ERROR PARSING ELEMENT AT POSITION " + i + " OF ARRAY " + jsonArray.toString());
            }
        }
        return list;
    }
}
