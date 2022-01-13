package com.example.shoppingcart;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;
import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static org.hamcrest.Matchers.allOf;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<MainActivity>(MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.shoppingcart", appContext.getPackageName());
    }
    @Test
    public void doTestStuff(){
        onView(allOf(withId(0))).perform(click());
        onView(allOf(withId(0))).perform(click());
        onView(withId(R.id.clickedItem)).check(matches(withText("Mjöl")));
        onView(allOf(withId(2))).perform(click());
        onView(allOf(withId(2))).perform(click());
        onView(allOf(withId(1))).perform(click());
        onView(withId(R.id.clickedItem)).check(matches(withText("Bröd")));
        onView(allOf(withId(1))).perform(click());
        onView(allOf(withId(1))).perform(click());
        onView(allOf(withId(1))).perform(click());
        onView(withId(R.id.itemsInBag)).check(matches(withText("You have 8 items in your cart")));
        onView(withId(R.id.cartButton)).perform(click());
        onView(withId(R.id.clickedItem)).check(matches(withText("You have opened the shoppingcard")));
        onView(ViewMatchers.withId(10)).inRoot(RootMatchers.isPlatformPopup()).perform(ViewActions.click());
        onView(ViewMatchers.withId(11)).inRoot(RootMatchers.isPlatformPopup()).perform(ViewActions.click());
        onView(ViewMatchers.withId(12)).inRoot(RootMatchers.isPlatformPopup()).perform(ViewActions.click());
        onView(withId(R.id.itemsInBag)).check(matches(withText("You have 5 items in your cart")));
    }

}