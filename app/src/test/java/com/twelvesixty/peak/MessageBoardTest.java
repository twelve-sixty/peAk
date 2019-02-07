package com.twelvesixty.peak;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageBoardTest {
    MessageBoard m = new MessageBoard();

    @Test
    public void getSetTeamTest() {
        Team fakeTeam = new Team();
        m.setTeam(fakeTeam);
        assertEquals(m.getTeam(), fakeTeam);
    }

    @Test
    public void getSetTeamTest2() {
        Team fakeTeam2 = new Team();
        m.setTeam(fakeTeam2);
        assertEquals(m.getTeam(), fakeTeam2);
    }

    @Test
    public void getSetTeamTest3() {
        Team fakeTeam3 = new Team();
        m.setTeam(fakeTeam3);
        assertEquals(m.getTeam(), fakeTeam3);
    }

    @Test
    public void getSetConstructorTest() {
        Team team = new Team();
        MessageBoard m = new MessageBoard(team);

        assertEquals(m.getTeam(),team);

    }

}