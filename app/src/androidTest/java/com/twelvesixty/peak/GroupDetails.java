package com.twelvesixty.peak;

import com.twelvesixty.peak.activity.GroupDetailsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class GroupDetails {

    @Rule
    public ActivityTestRule<GroupDetailsActivity> mActivityRule =
            new ActivityTestRule<>(GroupDetailsActivity.class);

    @Test
    public void testGroupDetailViews() {
        onView(withId(R.id.groupName)).check(matches(isDisplayed()));
        onView(withId(R.id.dateLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.resortLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.capacityLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.descriptionLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.stateLabel)).check(matches(isDisplayed()));
        // This is failing because that button isn't displayed.
        onView(withId(R.id.sendButton)).check(matches(isDisplayed()));
        onView(withId(R.id.sendButton)).check(matches(isClickable()));
    }
}
