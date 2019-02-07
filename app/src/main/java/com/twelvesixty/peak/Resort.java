package com.twelvesixty.peak;

import java.util.ArrayList;

public class Resort {
    private long id;
    private String name;
    private double latitude;
    private double longitude;
    private String websiteUrl;
    private ArrayList<Team> teamsList;
    private ResortAddress address;

    public Resort () {}

    public Resort (long id, String name, double latitude, double longitude, String websiteUrl,
                   ArrayList<Team> teamsList, ResortAddress address) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.websiteUrl = websiteUrl;
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

    public String getWebsiteUrl() {
        return websiteUrl;
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

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public void setTeamsList(ArrayList<Team> teamsList) {
        this.teamsList = teamsList;
    }

    public void setAddress(ResortAddress address) {
        this.address = address;
    }
}
