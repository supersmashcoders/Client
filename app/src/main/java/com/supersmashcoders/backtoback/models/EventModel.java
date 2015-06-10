package com.supersmashcoders.backtoback.models;

import android.util.Log;

import com.supersmashcoders.backtoback.converters.Converters;
import com.supersmashcoders.backtoback.converters.JsonArrayConverter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;

public class EventModel {
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private UserEntity owner;
    private List<String> tags;
    private List<UserEntity> attendants;
    private List<ImageEntity> photos;

    private EventModel(Long id, String name, String description, Date startDate, Date endDate,
                       UserEntity owner, List<String> tags, List<UserEntity> attendants,
                       List<ImageEntity> photos) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.owner = owner;
        this.tags = tags;
        this.attendants = attendants;
        this.photos = photos;
    }

    public static EventModel of(Long id, String name, String description, Date startDate, Date endDate,
                                UserEntity owner, List<String> tags, List<UserEntity> attendants,
                                List<ImageEntity> photos) {
        return new EventModel(id, name, description, startDate, endDate, owner, tags, attendants, photos);
    }

    public static EventModel of(JSONObject jsonEvent) {
        try {
            Long id = jsonEvent.getLong("id");
            String name = jsonEvent.getString("name");
            String description = jsonEvent.getString("description");
            Date startDate = new Date(jsonEvent.getLong("startDate"));
            Date endDate = new Date(jsonEvent.getLong("endDate"));
            UserEntity owner = UserEntity.of(jsonEvent.getJSONObject("owner"));
            List<String> tags = JsonArrayConverter.toStringList(jsonEvent.getJSONArray("tags"));
            List<UserEntity> attendants = JsonArrayConverter.toList(jsonEvent.getJSONArray("attendants"), new Converters.UserConverter());
            List<ImageEntity> photos = JsonArrayConverter.toList(jsonEvent.getJSONArray("photos"), new Converters.ImageConverter());
            return new EventModel(id, name, description, startDate, endDate, owner, tags, attendants, photos);
        } catch(JSONException e) {
            Log.e("JSON PARSE", "ERROR PARSING " + jsonEvent.toString());
            return null;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<UserEntity> getAttendants() {
        return attendants;
    }

    public void setAttendants(List<UserEntity> attendants) {
        this.attendants = attendants;
    }

    public List<ImageEntity> getPhotos() {
        return photos;
    }

    public void setPhotos(List<ImageEntity> photos) {
        this.photos = photos;
    }
}
