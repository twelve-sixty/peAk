package com.twelvesixty.peak;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SignUpTests {
    @Rule
    public ActivityTestRule<Signup> mActivityRule =
            new ActivityTestRule<>(Signup.class);

    @Test
    public void testLayoutDisplay() {
        onView(withId(R.id.UserSignUp)).check(matches(withHint("Username")));
        onView(withId(R.id.PasswordSignUp)).check(matches(withHint("Password")));
        onView(withId(R.id.BioSignUp)).check(matches(withHint("Bio")));
        onView(withId(R.id.DOBSignUp)).check(matches(withHint("Date Of Birth")));
        onView(withId(R.id.EmailSignUp)).check(matches(withHint("Email")));
        onView(withId(R.id.Button)).check(matches(withText("Sign Up")));
    }
}
