package com.imber.androidjokelibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeActivityFragment extends Fragment {

    public static final String JOKE_LABEL = "joke_label";

    public JokeActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke, container, false);
        // Retrieve joke from intent
        String joke = getActivity().getIntent().getStringExtra(JOKE_LABEL);
        if (joke == null) {
            joke = "Joke not found.";
        }
        ((TextView) root.findViewById(R.id.joke_textview)).setText(joke);
        return root;
    }
}
