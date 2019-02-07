package com.twelvesixty.peak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Team {
    private int capacity;
    private String name;
    private String dateGoing;
    private String timeGoing;
    private String description;
    private List<HashMap<String, Boolean>> tagsList;
    private ArrayList<User> userList;
    private User teamLeader;

    public Team () {}

    public Team (int capacity, String name, String dateGoing, String timeGoing,
                String description, List<HashMap<String, Boolean>> tagsList,
                 User teamLeader) {
        this.capacity = capacity;
        this.name = name;
        this. dateGoing = dateGoing;
        this.timeGoing = timeGoing;
        this.description = description;
        this.tagsList = tagsList;
        this.userList = new ArrayList<>();
        this.teamLeader = teamLeader;
    }

    ////////////////////// -- getters

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public String getDateGoing() {
        return dateGoing;
    }

    public String getTimeGoing() {
        return timeGoing;
    }

    public String getDescription() {
        return description;
    }

    public List<HashMap<String, Boolean>> getTagsList() {
        return tagsList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public User getTeamLeader() {
        return teamLeader;
    }

    ////////////////////// -- setters


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateGoing(String dateGoing) {
        this.dateGoing = dateGoing;
    }

    public void setTimeGoing(String timeGoing) {
        this.timeGoing = timeGoing;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTagsList(List<HashMap<String, Boolean>> tagsList) {
        this.tagsList = tagsList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public void setTeamLeader(User teamLeader) {
        this.teamLeader = teamLeader;
    }
}
