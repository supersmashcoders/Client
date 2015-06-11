package com.supersmashcoders.backtoback.models;

import android.util.Log;

import com.supersmashcoders.backtoback.converters.JsonArrayConverter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public class UserEntity implements Serializable {

    private Long id;
    private String username;
    private String bio;
    private List<String> passions;

    private UserEntity(Long id, String username, String bio, List<String> passions) {
        this.id = id;
        this.username = username;
        this.bio = bio;
        this.passions = passions;
    }

    public static UserEntity of(Long id, String username, String bio, List<String> passions) {
        return new UserEntity(id, username, bio, passions);
    }

    public static UserEntity of(JSONObject jsonUser) {
        try {
            Long id = jsonUser.getLong("id");
            String username = jsonUser.getString("username");
            String bio = jsonUser.getString("bio");
            List<String> passions = JsonArrayConverter.toStringList(jsonUser.getJSONArray("passions"));
            return new UserEntity(id, username, bio, passions);
        } catch (JSONException e) {
            Log.e("JSON PARSE", "ERROR PARSING " + jsonUser.toString());
            return null;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<String> getPassions() {
        return passions;
    }

    public void setPassions(List<String> passions) {
        this.passions = passions;
    }
}
