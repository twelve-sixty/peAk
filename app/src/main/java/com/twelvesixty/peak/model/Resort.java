package com.twelvesixty.peak.model;

import java.util.ArrayList;

public class Resort {
    private long id;
    private String name;
    private double latitude;
    private double longitude;
    private String websiteUrl;
    private ArrayList<Team> teams;
    private String resort_address_line1;
    private String resort_address_line2;
    private String resort_address_city;
    private String resort_address_state;
    private long resort_address_zip_code;

    public Resort () {}


    public Resort (String name, double latitude, double longitude, String websiteUrl,
                   ArrayList<Team> teams) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.websiteUrl = websiteUrl;
        this.teams = teams;
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

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public String getAddress() {
        if (this.resort_address_line2 == null || this.resort_address_line2.equals("")) {
            return this.resort_address_line1 + "\n" + this.resort_address_city + ", " + this.resort_address_state + " " + this.resort_address_zip_code;
        } else {
            return this.resort_address_line1 + "\n" + this.resort_address_line2 + "\n" + this.resort_address_city + ", " + this.resort_address_state + " " + this.resort_address_zip_code;
        }
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

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }


    public String getResort_address_line1() {
        return resort_address_line1;
    }

    public void setResort_address_line1(String resort_address_line1) {
        this.resort_address_line1 = resort_address_line1;
    }

    public String getResort_address_line2() {
        return resort_address_line2;
    }

    public void setResort_address_line2(String resort_address_line2) {
        this.resort_address_line2 = resort_address_line2;
    }

    public String getResort_address_city() {
        return resort_address_city;
    }

    public void setResort_address_city(String resort_address_city) {
        this.resort_address_city = resort_address_city;
    }

    public String getResort_address_state() {
        return resort_address_state;
    }

    public void setResort_address_state(String resort_address_state) {
        this.resort_address_state = resort_address_state;
    }

    public long getResort_address_zip_code() {
        return resort_address_zip_code;
    }

    public void setResort_address_zip_code(long resort_address_zip_code) {
        this.resort_address_zip_code = resort_address_zip_code;
    }
}
