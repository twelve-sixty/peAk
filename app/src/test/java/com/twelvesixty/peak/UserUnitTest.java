package com.twelvesixty.peak;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserUnitTest {

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


}
