package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.imber.androidjokelibrary.JokeActivity;
import com.imber.androidjokelibrary.JokeActivityFragment;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        final ProgressBar progressBar = (ProgressBar) root.findViewById(R.id.progress_bar);

        Button tellJokeButton = (Button) root.findViewById(R.id.tell_joke_button);
        tellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                new FetchJokeAsyncTask().execute(new FetchJokeAsyncTask.FetchJokeTaskCallback() {
                    @Override
                    public void handleJoke(String joke) {
                        progressBar.setVisibility(View.GONE);
                        Intent intent = new Intent(getContext(), JokeActivity.class);
                        intent.putExtra(JokeActivityFragment.JOKE_LABEL, joke);
                        getContext().startActivity(intent);
                    }
                });
            }
        });
        return root;
    }


}
