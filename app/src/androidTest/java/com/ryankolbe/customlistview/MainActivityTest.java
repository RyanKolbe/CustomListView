package com.ryankolbe.customlistview;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test_ActivityViewActive() {
        onView(withId(R.id.lv_country_list)).check(matches(isDisplayed()));
    }

    @Test
    public void test_CustomListClick() {
        onData(allOf())
                .inAdapterView(withId(R.id.lv_country_list))
                .atPosition(3)
                .perform(click());
    }

    @Test
    public void test_ToastMessage() {
        onData(allOf())
                .inAdapterView(withId(R.id.lv_country_list))
                .atPosition(5)
                .perform(click());

        onView(withText("You clicked on: United Kingdom")).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }
}