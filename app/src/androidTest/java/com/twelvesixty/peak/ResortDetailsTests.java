package com.twelvesixty.peak;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ResortDetailsTests {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testDropDownForWeather() {
        onView(withId(R.id.weatherDrop)).check(matches(isDisplayed()));
        onView(withId(R.id.weather)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.weatherDrop)).perform(click());
        onView(withId(R.id.weather)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.weatherDrop)).perform(click());
        onView(withId(R.id.weather)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

    @Test
    public void testDropDownForResorts() {
        onView(withId(R.id.resortsInfoDrop)).check(matches(isDisplayed()));
        onView(withId(R.id.resortsInfo)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.resortsInfoDrop)).perform(click());
        onView(withId(R.id.resortsInfo)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.resortsInfoDrop)).perform(click());
        onView(withId(R.id.resortsInfo)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

    @Test
    public void mapDisplayTest() {
        onView(withId(R.id.mapView)).check(matches(isDisplayed()));
    }

}
