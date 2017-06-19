package com.vinay.wizdem.techrad.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubePlayerView;
import com.vinay.wizdem.techrad.Adapters.SongViewAdapter;
import com.vinay.wizdem.techrad.R;
import com.vinay.wizdem.techrad.Utils.Utils;

/**
 * Created by vinay_1 on 6/16/2017.
 */

public class SongsListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public YouTubePlayerView youTubePlayerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_songs_list,container,false);

        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.song_view_recycler_view_1);

        //   youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);

        // mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // geting string api_key form string resourse
      //  String str=getResources().getString(R.string.your_google_api_key);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
//        TextView textView = (TextView) findViewById(R.id.test_text);
/*
        Bundle bundle = getIntent().getExtras();
        int position= bundle.getInt("ITEM_POSITION");*/
        int position = Utils.my_adapter_position;
//            textView.setText(Utils.modelData.getStatuses().get(position).getSongs().get(2).getSongName().toString());
        try {
            mAdapter = new SongViewAdapter(position);
            mRecyclerView.setAdapter(mAdapter);
        }catch (NullPointerException e){
            throw new NullPointerException();
        }

        return  rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
