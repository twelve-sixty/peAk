package com.twelvesixty.peak;

import java.util.ArrayList;

public class Resort {
    private long id;
    private String name;
    private double latitude;
    private double longitude;
    private String websiteURL;
    private ArrayList<Team> teamsList;
    private ResortAddress address;

    public Resort () {}

    public Resort (String name, double latitude, double longitude, String websiteURL,
                   ArrayList<Team> teamsList, ResortAddress address) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.websiteURL = websiteURL;
        this.teamsList = teamsList;
        this.address = address;
    }

    ////////////////////// -- getters

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public ArrayList<Team> getTeamsList() {
        return teamsList;
    }

    public ResortAddress getAddress() {
        return address;
    }

    ////////////////////// -- setters

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public void setTeamsList(ArrayList<Team> teamsList) {
        this.teamsList = teamsList;
    }

    public void setAddress(ResortAddress address) {
        this.address = address;
    }
}
