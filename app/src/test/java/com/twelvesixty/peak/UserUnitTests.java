package com.twelvesixty.peak;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserUnitTests {

    @Test
    public void UserGettersTest() {

        User fakeUser = new User();

        // name getters and setters
        fakeUser.setName("Shaun White");
        assertEquals(fakeUser.getName(), "Shaun White");

        // bio getters and setters
        fakeUser.setBio("Half Pipe King");
        assertEquals(fakeUser.getBio(), "Half Pipe King");

        // email getters and setters
        fakeUser.setEmail("carrot_top_1080@gmail.com");
        assertEquals(fakeUser.getEmail(), "carrot_top_1080@gmail.com");

        // date of birth getters and setters
        fakeUser.setDateOfBirth("11/9/1986");
        assertEquals(fakeUser.getDateOfBirth(), "11/9/1986");

        // username getters and setters
        fakeUser.setUsername("carrot_top_99");
        assertEquals(fakeUser.getUsername(), "carrot_top_99");

        fakeUser.setId(1);
        assertEquals(fakeUser.getId(), 1);
    }

    @Test
    public void userContructorTest() {
        User shaunWhite = new User("Shaun White", "carrot_top_USA", "01/24/1986",
                "superpipeKing99@gmail.com", "All I do is win");

        assertEquals(shaunWhite.getName(), "Shaun White");

        assertEquals(shaunWhite.getBio(), "All I do is win");

        assertEquals(shaunWhite.getEmail(), "superpipeKing99@gmail.com");

        assertEquals(shaunWhite.getDateOfBirth(), "01/24/1986");

        assertEquals(shaunWhite.getUsername(), "carrot_top_USA");

        assertEquals(shaunWhite.getId(), 0);




    }


}
