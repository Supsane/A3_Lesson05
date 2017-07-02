package ru.geekbrains.gviewer.model.entity;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class GithubUser extends RealmObject {

    @PrimaryKey
    private String login;

    private String id;

    @SerializedName("avatar_url")
    private String avatarURL;

    @SerializedName("html_url")
    private String site;

    private String name;
    private String location;
    private String company;
    private String email;
    private String bio;

    public String getBio() {
        return bio;
    }

    public String getSite() {
        return site;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    @Nullable
    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }
}