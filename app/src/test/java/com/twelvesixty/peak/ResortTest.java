package com.twelvesixty.peak;

import com.twelvesixty.peak.model.Resort;
import com.twelvesixty.peak.model.Team;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ResortTest {
    // To keep your tests independent, these variables should be set in an @Before method.
    Resort r = new Resort();
    Team t = new Team();
    Team e = new Team();
    ArrayList<Team> teamList = new ArrayList<>();


    @Test
    public void getSetIdTest() {
        r.setId(1);
        assertEquals(r.getId(), 1);
    }

    @Test
    public void getSetNameTest() {
        r.setName("happy birthday Nick");

        assertEquals(r.getName(), "happy birthday Nick");
    }

    @Test
    public void getSetLatTest() {
        r.setLatitude(47.062);

        assertEquals(r.getLatitude(), 47.062 , 0);
    }

    @Test
    public void getSetLongTest() {
        r.setLongitude(47.062);

        assertEquals(r.getLongitude(), 47.062, 0);
    }

    @Test
    public void getSetWebsiteURLTest() {
        r.setWebsiteUrl("https://www.google.com/");

        assertEquals(r.getWebsiteUrl(), "https://www.google.com/");
    }

    @Test
    public void getSetConstructorTest() {
        // Since you only use the teamList variable here, you can declare it locally.
        teamList.add(t);
        teamList.add(e);
        Resort fakeResort = new Resort("ASUS", 47.062, 47.062, "https://www.google.com/", teamList);

        assertEquals(fakeResort.getName(), "ASUS");
        assertEquals(fakeResort.getLatitude(), 47.062, 0);
        assertEquals(fakeResort.getLongitude(), 47.062, 0);
        assertEquals(fakeResort.getWebsiteUrl(), "https://www.google.com/");
        assertEquals(fakeResort.getTeams(), teamList);
        assertEquals(fakeResort.getAddress(), "null\n" +
                "null, null 0");



    }
}
