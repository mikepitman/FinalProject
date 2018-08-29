package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNull;

/*
Solution for accessing asyncTask output from test class taken from
http://marksunghunpark.blogspot.com/2015/05/how-to-test-asynctask-in-android.html
 */

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    private String joke = null;
    private Exception exception = null;
    private CountDownLatch signal = null;

    @Before
    public void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @After
    public void tearDown() throws Exception {
        signal.countDown();
    }

    @Test
    public void checkAsyncTaskReturnsJoke() throws Exception {
        MainActivity mainActivity = mActivityRule.getActivity();

        EndpointsAsyncTask task = new EndpointsAsyncTask(mainActivity);
        task.setListener(new EndpointsAsyncTask.EndpointsAsyncTaskListener() {
            @Override
            public void onComplete(String returnedJoke, Exception e) {
                joke = returnedJoke;
                exception = e;
                signal.countDown();
            }
        }).execute(mainActivity);
        signal.await();

        assertNull(exception);
        assertFalse(TextUtils.isEmpty(joke));
    }
}
