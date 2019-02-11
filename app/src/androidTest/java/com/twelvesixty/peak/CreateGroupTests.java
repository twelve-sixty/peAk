package com.twelvesixty.peak;

import com.twelvesixty.peak.activity.CreateGroupActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CreateGroupTests {

    @Rule
    public ActivityTestRule<CreateGroupActivity> mActivityRule =
            new ActivityTestRule<>(CreateGroupActivity.class);

    @Test
    public void testCreateGroupViews() {
        onView(withId(R.id.editText_capacity)).check(matches(isDisplayed()));
        onView(withId(R.id.editText_capacity)).perform(typeText("Test Text"));

        onView(withId(R.id.editText_groupName)).check(matches(isDisplayed()));
        onView(withId(R.id.editText_groupName)).perform(typeText("Test Text"));

        onView(withId(R.id.editText_groupDateGoing)).check(matches(isDisplayed()));
        onView(withId(R.id.editText_groupDateGoing)).perform(click());

        onView(withId(R.id.editText_groupTimeMeeting)).check(matches(isDisplayed()));
        onView(withId(R.id.editText_groupTimeMeeting)).perform(click());

        onView(withId(R.id.editText_groupDescription)).check(matches(isDisplayed()));
        onView(withId(R.id.editText_groupDescription)).perform(typeText("Test Text"));

        onView(withId(R.id.textView_GroupCategoriesTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_GroupCategoriesTitle)).perform(ViewActions.pressBack());

        onView(withId(R.id.checkBox_PartyHardy)).check(matches(isDisplayed()));
        onView(withId(R.id.checkBox_PartyHardy)).perform(click());

        onView(withId(R.id.checkBox_OffPiste)).check(matches(isDisplayed()));
        onView(withId(R.id.checkBox_OffPiste)).perform(click());


        onView(withId(R.id.checkBox_TerrainPark)).check(matches(isDisplayed()));
        onView(withId(R.id.checkBox_TerrainPark)).perform(click());


        onView(withId(R.id.checkBox_FamilyFriendly)).check(matches(isDisplayed()));
        onView(withId(R.id.checkBox_FamilyFriendly)).perform(click());


        onView(withId(R.id.checkBox_GreenCircle)).check(matches(isDisplayed()));
        onView(withId(R.id.checkBox_GreenCircle)).perform(click());


        onView(withId(R.id.checkBox_BlueSquare)).check(matches(isDisplayed()));
        onView(withId(R.id.checkBox_BlueSquare)).perform(click());


        onView(withId(R.id.checkBox_BlackDiamonds)).check(matches(isDisplayed()));
        onView(withId(R.id.checkBox_BlackDiamonds)).perform(click());


        onView(withId(R.id.checkBox_DoubleBlackDiamonds)).check(matches(isDisplayed()));
        onView(withId(R.id.checkBox_DoubleBlackDiamonds)).perform(click());

        onView(withId(R.id.button_CreateGroup)).check(matches(isClickable()));
    }
}
