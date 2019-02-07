package com.twelvesixty.peak;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TeamUnitTests {

    @Test
    public void teamGettersAndSetters() {

        Team fakeTeam = new Team();

        // team capacity getters and setters
        fakeTeam.setCapacity(10);
        assertEquals(fakeTeam.getCapacity(), 10);

        // dateGoing getters and setters
        fakeTeam.setDateAndTimeGoing("02/07/2019 08:00 a");
        assertEquals(fakeTeam.getDateAndTimeGoingGoing(), "02/07/2019 08:00 a");

        // description getters and setters
        fakeTeam.setDescription("Powder, all day everyday.");
        assertEquals(fakeTeam.getDescription(), "Powder, all day everyday.");

        // id getters and setters
        fakeTeam.setId(8);
        assertEquals(fakeTeam.getId(), 8);

        // name getters and setters
        fakeTeam.setName("Powder Surfers");
        assertEquals(fakeTeam.getName(), "Powder Surfers");

        // status getters and setters
        fakeTeam.setStatus("Active");
        assertEquals(fakeTeam.getStatus(), "Active");

        // resort getters and setters
        Resort fakeResort = new Resort();
        fakeTeam.setResort(fakeResort);
        assertEquals(fakeTeam.getResort(), fakeResort);

        // tagsMap getters and setters
        HashMap<String, Boolean> fakeTagsMap = new HashMap<>();
        fakeTagsMap.put("blueSquare", true);
        fakeTeam.setTagsMap(fakeTagsMap);
        assertEquals(fakeTeam.getTagsMap(), fakeTagsMap);

        // user getter and setter
        User fakeTeamLeader = new User();
        fakeTeamLeader.setName("Shaun White");
        fakeTeam.setTeamLeader(fakeTeamLeader);
        assertEquals(fakeTeam.getTeamLeader(), fakeTeamLeader);

        // user list getters and setters
        ArrayList<User> usersList = new ArrayList<>();
        User fakeTeamMember = new User();
        fakeTeamMember.setName("Michael Phelps");
        usersList.add(fakeTeamLeader);
        usersList.add(fakeTeamMember);
        fakeTeam.setUserList(usersList);
        assertEquals(fakeTeam.getUserList(), usersList);

        // test messageList getters and setters
        ArrayList<Messages> messagesList = new ArrayList<>();
        Messages fakeMessage1 = new Messages();
        Messages fakeMessage2 = new Messages();
        Messages fakeMessage3 = new Messages();
        messagesList.add(fakeMessage1);
        messagesList.add(fakeMessage2);
        messagesList.add(fakeMessage3);
        fakeTeam.setMessagesList(messagesList);
        assertEquals(fakeTeam.getMessagesList(), messagesList);
    }

    @Test
    public void teamSecondConstructorTest() {

        // tagsMap getters and setters
        HashMap<String, Boolean> fakeTagsMap = new HashMap<>();
        fakeTagsMap.put("blueSquare", true);

        User fakeTeamLeader2 = new User();
        fakeTeamLeader2.setName("Shaun White");

        Resort fakeResort2 = new Resort();

        Team fakeTeam2 = new Team(4, "Fly boys", "02/07/2019 08:00 a",
                "Park Junkies", fakeTagsMap, fakeTeamLeader2, fakeResort2, "Active");

        assertEquals(fakeTeam2.getCapacity(), 4);

        assertEquals(fakeTeam2.getName(), "Fly boys");

        assertEquals(fakeTeam2.getDateAndTimeGoingGoing(), "02/07/2019 08:00 a");

        assertEquals(fakeTeam2.getDescription(), "Park Junkies");

        assertEquals(fakeTeam2.getTagsMap(), fakeTagsMap);

        assertEquals(fakeTeam2.getTeamLeader(), fakeTeamLeader2);

        assertEquals(fakeTeam2.getResort(), fakeResort2);

        assertEquals(fakeTeam2.getStatus(), "Active");

    }
}
