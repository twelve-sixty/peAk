package com.twelvesixty.peak;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessagesTest {
    Messages m = new Messages();

    @Test
    public void getSetIdTest() {
        m.setId(123);

        assertEquals(m.getId(), 123);
    }

    @Test
    public void getSetMessageBoard() {
        MessageBoard  fakeMessageBoard = new MessageBoard();
        m.setMessageBoard(fakeMessageBoard);
        assertEquals(m.getMessageBoard(), fakeMessageBoard);
    }

    @Test
    public void getSetMessageAuthor() {
        User fakeMessageAuthor = new User();
        m.setMessageAuthor(fakeMessageAuthor);
        assertEquals(m.getMessageAuthor(), fakeMessageAuthor);
    }

}