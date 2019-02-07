package com.twelvesixty.peak;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ProfileTests {

    @Rule
    public ActivityTestRule<UserProfileActivty> mActivityRule =
            new ActivityTestRule<>(UserProfileActivty.class);

    @Test
    public void testProfileActivityViews() {
        onView(withId(R.id.linearLayout_default)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.linearLayout_editable)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));

        onView(withId(R.id.textView_Username)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_Bio)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_dateOfBirth)).check(matches(isDisplayed()));

        onView(withId(R.id.button_EditProfile)).perform(click());

        onView(withId(R.id.linearLayout_default)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.linearLayout_editable)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        onView(withId(R.id.textView_Username_Copy)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_Bio_Editable)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_dateOfBirth_Copy)).check(matches(isDisplayed()));

        onView(withId(R.id.textView_Bio_Editable)).perform(typeText("Powder Surfer"));

        onView(withId(R.id.button_EditProfile)).perform(ViewActions.pressBack());
        onView(withId(R.id.button_EditProfile)).perform(click());

        onView(withId(R.id.textView_Bio)).check(matches(withText("Powder Surfer")));
        onView(withId(R.id.linearLayout_default)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.linearLayout_editable)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));

    }
}
