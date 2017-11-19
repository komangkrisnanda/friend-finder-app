package com.komangkrisnanda.friendfinders.models;

import com.google.gson.Gson;

/**
 * Created by root on 18/11/17.
 */

public class User {

    private String name;
    private String imageUrl;

    public User() {
    }

    public User(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String toJson(){
        return new Gson().toJson(this);
    }

    public User fromJson(String usersJson){
        return new Gson().fromJson(usersJson, User.class);
    }
}
