package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class AsyncTaskTest extends AndroidTestCase {
    private final String LOG_TAG = this.getClass().getCanonicalName();

    public void testAsyncTask() {
        String joke = "";
        try {
            FetchJokeAsyncTask jokeTask = new FetchJokeAsyncTask();
            jokeTask.execute(new FetchJokeAsyncTask.FetchJokeTaskCallback() {
                @Override
                public void handleJoke(String joke) {
                    // empty handler
                }
            });
            joke = jokeTask.get(15, TimeUnit.SECONDS);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
        }
        assertFalse("FetchJokeAsyncTask returned empty string", joke.equals(""));
    }
}