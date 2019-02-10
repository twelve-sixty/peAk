package com.twelvesixty.peak;

import com.twelvesixty.peak.activity.MainActivity;

import org.junit.Rule;
import org.junit.runner.RunWith;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTests {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

//    cant run these tests unless the user is Logged out of the app.
//    @Test
//    public void inputTests() {
//        onView(withId(R.id.UserLogin)).check(ViewAssertions.matches(withHint("Username")));
//        onView(withId(R.id.UserPassword)).check(ViewAssertions.matches(withHint("Password")));
//        onView(withId(R.id.GoToSignUpButton)).check(ViewAssertions.matches(withText("Sign Up")));
//        onView(withId(R.id.LoginButton)).check(ViewAssertions.matches(withText("Login")));
//        onView(withId(R.id.UserLogin)).perform(typeText("KevinRosales"));
//        onView(withId(R.id.UserLogin)).check(ViewAssertions.matches(withText("KevinRosales")));
//        onView(withId(R.id.UserPassword)).perform(typeText("k e v i n r o s a l e s"));
//        onView(withId(R.id.UserPassword)).check(ViewAssertions.matches(withText("k e v i n r o s a l e s")));
//    }

}
