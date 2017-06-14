package com.vinay.wizdem.techrad.Activities;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.thefinestartist.ytpa.YouTubePlayerActivity;
import com.vinay.wizdem.techrad.Adapters.SongViewAdapter;
import com.vinay.wizdem.techrad.R;
import com.vinay.wizdem.techrad.Utils.Utils;

/**
 * Created by vinay_1 on 6/11/2017.
 */

public class OpenYouTubePlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private String API_KEY = "AIzaSyD--Hz_BxdftFqZdoe8AAZ8tqOLVBvxWC4";
    private int song_position;
    private int chennal_position;
    private String video_id;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_player_acitivity);

        Bundle bundle = getIntent().getExtras();
        chennal_position = bundle.getInt("CHANNEL_POSITION");
        song_position = bundle.getInt("SONG_POSITION");
        video_id = Utils.modelData.getStatuses().get(chennal_position).getSongs().get(song_position).getSongUrl().toString();
        id = String.valueOf(video_id.substring(video_id.length()-11));

        // Initializing YouTube player view
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if(null== youTubePlayer) return;

        // Start buffering
        if (!wasRestored) {
            youTubePlayer.cueVideo(id);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failed to initialize."+ youTubeInitializationResult, Toast.LENGTH_LONG).show();

    }
}
