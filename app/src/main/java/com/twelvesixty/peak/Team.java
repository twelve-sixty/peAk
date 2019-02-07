package com.twelvesixty.peak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Team {
    private long id;
    private int capacity;
    private String name;
    private String dateAndTimeGoing;
    private String description;
    private HashMap<String, Boolean> tagsMap;
    private ArrayList<User> userList;
    private User teamLeader;
    private ArrayList<Messages> messagesList;

    public Team () {}

    public Team (int capacity, String name, String dateAndTimeGoing,
                String description, HashMap<String, Boolean> tagsMap,
                 User teamLeader) {
        this.capacity = capacity;
        this.name = name;
        this. dateAndTimeGoing = dateAndTimeGoing;
        this.description = description;
        this.tagsMap = tagsMap;
        this.userList = new ArrayList<>();
        this.teamLeader = teamLeader;
        this.messagesList = new ArrayList<>();
    }

    ////////////////////// -- getters

    public long getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public String getDateAndTimeGoingGoing() {
        return this.dateAndTimeGoing;
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

    ////////////////////// -- setters


    public void setId(long id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateAndTimeGoing(String dateAndTimeGoing) {
        this.dateAndTimeGoing = dateAndTimeGoing;
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
}
