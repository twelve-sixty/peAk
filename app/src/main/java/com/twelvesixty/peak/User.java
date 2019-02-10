package com.twelvesixty.peak;

//Class to model a User object
public class User {
    private long id;
    private String name;
    private String username;
    private String dateOfBirth;
    private String email;
    private String bio;

    public User () {}

    public User (String name, String username, String dateOfBirth, String email, String bio) {
        this.name = name;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.bio = bio;
    }

    ////////////////////// -- getters

    public long getId() {
        return id;
    }

    public String getName () {
        return this.name;
    }

    public String getUsername () {
        return this.username;
    }

    public String getDateOfBirth () {
        return this.dateOfBirth;
    }

    public String getEmail () {
        return this.email;
    }

    public String getBio () {
        return this.bio;
    }

    ////////////////////// -- setters


    public void setId(long id) {
        this.id = id;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public void setDateOfBirth (String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public void setBio (String bio) {
        this.bio = bio;
    }
}
