package com.supersmashcoders.backtoback.converters;

import com.supersmashcoders.backtoback.models.ImageEntity;
import com.supersmashcoders.backtoback.models.UserEntity;

import org.json.JSONObject;

public class Converters {
    public static class UserConverter implements Converter<UserEntity> {
        @Override
        public UserEntity convert(JSONObject object) {
            return UserEntity.of(object);
        }
    }

    public static class ImageConverter implements Converter<ImageEntity> {
        @Override
        public ImageEntity convert(JSONObject object) {
            return ImageEntity.of(object);
        }
    }
}
