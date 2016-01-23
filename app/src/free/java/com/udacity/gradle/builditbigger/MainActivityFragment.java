package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.imber.androidjokelibrary.JokeActivity;
import com.imber.androidjokelibrary.JokeActivityFragment;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    InterstitialAd mInterstitialAd;
    String mJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                mInterstitialAd.loadAd(getTestAdRequest());
                launchJokeActivity(mJoke);
            }
        });
        mInterstitialAd.loadAd(getTestAdRequest());

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        mAdView.loadAd(getTestAdRequest());

        final ProgressBar progressBar = (ProgressBar) root.findViewById(R.id.progress_bar);

        Button tellJokeButton = (Button) root.findViewById(R.id.tell_joke_button);
        tellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                new FetchJokeAsyncTask().execute(new FetchJokeAsyncTask.FetchJokeTaskCallback() {
                    @Override
                    public void handleJoke(String joke) {
                        mJoke = joke;
                        progressBar.setVisibility(View.GONE);
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            launchJokeActivity(joke);
                        }
                    }
                });
            }
        });
        return root;
    }

    private void launchJokeActivity(String joke) {
        Intent intent = new Intent(getContext(), JokeActivity.class);
        intent.putExtra(JokeActivityFragment.JOKE_LABEL, joke);
        getContext().startActivity(intent);
    }

    private AdRequest getTestAdRequest() {
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        return new AdRequest.Builder()
                .addTestDevice(getString(R.string.test_device_id))
                .build();
    }
}
