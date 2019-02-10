package com.twelvesixty.peak.model;

import java.util.ArrayList;
import java.util.HashMap;

//Class to model a team object
public class Team {
    private long id;
    private int maxCapacity;
    private int currentCapacity;
    private String name;
    private String meetDate;
    private String description;
    private HashMap<String, Boolean> tagsMap;
    private ArrayList<User> userList;
    private User teamLeader;
    private ArrayList<Messages> messagesList;
    private Resort resort;
    private String status;

    public Team () {}

    public Team (int maxCapacity, String name, String meetDate,
                 String description, HashMap<String, Boolean> tagsMap,
                 User teamLeader, Resort resort, String status) {
        this.maxCapacity = maxCapacity;
        this.name = name;
        this.meetDate = meetDate;
        this.description = description;
        this.tagsMap = tagsMap;
        this.userList = new ArrayList<>();
        this.teamLeader = teamLeader;
        this.messagesList = new ArrayList<>();
        this.resort = resort;
        this.status = status;
    }

    ////////////////////// -- getters

    public long getId() {
        return id;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getName() {
        return name;
    }

    public String getDateAndTimeGoingGoing() {
        return this.meetDate;
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, Boolean> getTagsMap() {
        return tagsMap;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public User getTeamLeader() {
        return teamLeader;
    }

    public ArrayList<Messages> getMessagesList() {
        return messagesList;
    }

    public Resort getResort() {
        return resort;
    }

    public String getStatus() {
        return status;
    }

    ////////////////////// -- setters


    public void setId(long id) {
        this.id = id;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeetDate(String meetDate) {
        this.meetDate = meetDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTagsMap(HashMap<String, Boolean> tagsMap) {
        this.tagsMap = tagsMap;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public void setTeamLeader(User teamLeader) {
        this.teamLeader = teamLeader;
    }

    public void setMessagesList(ArrayList<Messages> messagesList) {
        this.messagesList = messagesList;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }
}
