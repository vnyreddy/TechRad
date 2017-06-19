package com.vinay.wizdem.techrad.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.vinay.wizdem.techrad.R;
import com.vinay.wizdem.techrad.Utils.Utils;

import static android.provider.MediaStore.Video.Thumbnails.VIDEO_ID;

/**
 * Created by vinay_1 on 6/12/2017.
 */

public class YoutubeViewFragment extends Fragment {
    private String API_KEY = "AIzaSyD--Hz_BxdftFqZdoe8AAZ8tqOLVBvxWC4";
    private String video_id;
    private String id;
    private int myAdapter_position;
    private int songViewAdapter_position;

    public YoutubeViewFragment(int myAdapter_position, int songViewAdapter_position) {
        this.myAdapter_position = myAdapter_position;
        this.songViewAdapter_position = songViewAdapter_position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_youtube_view, container, false);

        video_id = Utils.modelData.getStatuses().get(myAdapter_position).getSongs().get(songViewAdapter_position).getSongUrl().toString();
        id = String.valueOf(video_id.substring(video_id.length()-11));

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_view, youTubePlayerFragment).commit();
        youTubePlayerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
                if (!wasRestored) {
                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    youTubePlayer.loadVideo(id);
                    youTubePlayer.play();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(rootView.getContext(), "Failed to initialize."+ youTubeInitializationResult, Toast.LENGTH_LONG).show();

            }
        });

        return rootView;
    }
}
