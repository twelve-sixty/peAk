package com.twelvesixty.peak;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResortTest {
    Resort r = new Resort();

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
        r.setWebsiteURL("https://www.google.com/");

        assertEquals(r.getWebsiteURL(), "https://www.google.com/");
    }

    @Test
    public void getSetAddress() {
        ResortAddress fakeAddress = new ResortAddress();
        r.setAddress(fakeAddress);
        assertEquals(r.getAddress(), fakeAddress);
    }
}
