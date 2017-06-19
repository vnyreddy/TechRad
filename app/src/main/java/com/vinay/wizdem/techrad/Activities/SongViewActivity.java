package com.vinay.wizdem.techrad.Activities;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerView;
import com.thefinestartist.ytpa.YouTubePlayerActivity;
import com.vinay.wizdem.techrad.Adapters.MyAdapter;
import com.vinay.wizdem.techrad.Adapters.SongViewAdapter;
import com.vinay.wizdem.techrad.Fragments.YoutubeViewFragment;
import com.vinay.wizdem.techrad.Models.MessageEvent;
import com.vinay.wizdem.techrad.R;
import com.vinay.wizdem.techrad.Utils.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;

public class SongViewActivity extends FragmentActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);



        //    setContentView(R.layout.activity_song_view);
    /*    mRecyclerView = (RecyclerView) findViewById(R.id.song_view_recycler_view);

     //   youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);

        // mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        String str=getResources().getString(R.string.your_google_api_key);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
//        TextView textView = (TextView) findViewById(R.id.test_text);

        Bundle bundle = getIntent().getExtras();
            int position= bundle.getInt("ITEM_POSITION");
//            textView.setText(Utils.modelData.getStatuses().get(position).getSongs().get(2).getSongName().toString());
        try {
            mAdapter = new SongViewAdapter(position);
            mRecyclerView.setAdapter(mAdapter);
        }catch (NullPointerException e){
            throw new NullPointerException();
        }
*/

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event){

        // Create a new Fragment to be placed in the activity layout
        YoutubeViewFragment youtubeViewFragment = new YoutubeViewFragment(event.myAdapter_position,event.songViewAdapter_position);

        // In case this activity was started with special instructions from an
        // Intent, pass the Intent's extras to the fragment as arguments
        //  youtubeViewFragment.setArguments(getIntent().getExtras());

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, youtubeViewFragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
