package com.twelvesixty.peak;

import java.util.HashMap;
import java.util.List;

public class Team {
    private int capacity;
    private String name;
    private String dateGoing;
    private String timeGoing;
    private String description;
    private List<HashMap<String, Boolean>> tagsList;

    public Team () {}

    public Team (int capacity, String name, String dateGoing, String timeGoing,
                String description, List<HashMap<String, Boolean>> tagsList) {
        this.capacity = capacity;
        this.name = name;
        this. dateGoing = dateGoing;
        this.timeGoing = timeGoing;
        this.description = description;
        this.tagsList = tagsList;

    }
}
