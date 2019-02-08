package com.twelvesixty.peak;

import org.junit.Rule;
import org.junit.Test;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainIntentTests {
    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);
/////////////////////////////Have to be logged out for this test to work////////////////////
    @Test
    public void goToSignUpButtonTest() {
        onView(withId(R.id.GoToSignUpButton)).perform(click());
        intended(hasComponent(Signup.class.getName()));
    }

}
