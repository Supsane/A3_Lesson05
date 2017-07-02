package ru.geekbrains.gviewer.model;

import ru.geekbrains.gviewer.model.entity.GithubUser;

/**
 * Created by Chashurin Evgeny on 02.07.2017.
 */

public class DBData {

    private final String NOINFORMATION = "Information is absent";

    private GithubUser githubUser = new GithubUser();

    private String login;
    private String id;
    private String avatarURL;
    private String site;
    private String name;
    private String location;
    private String company;
    private String email;
    private String bio;

    void setData() {
        login = githubUser.getLogin();
        id = githubUser.getId();
        if (githubUser.getAvatarURL() == null) {
            avatarURL = NOINFORMATION;
        } else {
            avatarURL = githubUser.getAvatarURL();
        }
        if (githubUser.getSite() == null) {
            site = NOINFORMATION;
        } else {
            site = githubUser.getSite();
        }
        if (githubUser.getName() == null) {
            name = NOINFORMATION;
        } else {
            name = githubUser.getName();
        }
        if (githubUser.getLocation() == null) {
            location = NOINFORMATION;
        } else {
            location = githubUser.getLocation();
        }
        if (githubUser.getCompany() == null) {
            company = NOINFORMATION;
        } else {
            company = githubUser.getCompany();
        }
        if (githubUser.getEmail() == null) {
            email = NOINFORMATION;
        } else {
            email = githubUser.getEmail();
        }
        if (githubUser.getBio() == null) {
            bio = NOINFORMATION;
        } else {
            bio = githubUser.getBio();
        }

    }

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public String getSite() {
        return site;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }
}
