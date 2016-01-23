package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.imber.androidjokeactivity.backend.myApi.MyApi;

import java.io.IOException;

public class FetchJokeAsyncTask extends AsyncTask<FetchJokeAsyncTask.FetchJokeTaskCallback, Void, String> {
    private static MyApi myApiService = null;
    private FetchJokeTaskCallback callback;

    @Override
    protected String doInBackground(FetchJokeTaskCallback callbacks[]) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(
                    AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1196.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        callback = callbacks[0];

        try {
            //return myApiService.sayHi("name").execute().getData();
            return myApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String jokeResult) {
        callback.handleJoke(jokeResult);
    }

    public interface FetchJokeTaskCallback {
        void handleJoke(String joke);
    }
}
