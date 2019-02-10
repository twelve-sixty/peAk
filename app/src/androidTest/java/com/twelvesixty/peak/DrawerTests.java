package com.twelvesixty.peak;

import android.view.Gravity;

import com.twelvesixty.peak.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DrawerTests {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testNavDrawer() {
        onView(withId(R.id.nav_view)).check(matches(not(isDisplayed())));
        DrawerActions.openDrawer(R.id.drawer_layout, Gravity.START);
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()));
        onView(withText("Logout")).check(matches(isDisplayed()));
        onView(withText("Profile")).check(matches(isDisplayed()));
        onView(withText("My Groups")).check(matches(isDisplayed()));
        DrawerActions.closeDrawer(R.id.drawer_layout, Gravity.START);
        onView(withId(R.id.nav_view)).check(matches(not(isDisplayed())));
    }

    @Test
    public void testRightDrawer() {
        onView(withId(R.id.right_side)).check(matches(not(isDisplayed())));
        DrawerActions.openDrawer(R.id.drawer_layout, Gravity.END);
        onView(withId(R.id.right_side)).check(matches(isDisplayed()));
        onView(withId(R.id.recycler_nav)).check(matches(isDisplayed()));
        DrawerActions.closeDrawer(R.id.drawer_layout, Gravity.END);
        onView(withId(R.id.right_side)).check(matches(not(isDisplayed())));
    }
}
