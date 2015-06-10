package com.supersmashcoders.backtoback.converters;

import org.json.JSONObject;

public interface Converter<T> {
    public <T> T convert(JSONObject object);
}
