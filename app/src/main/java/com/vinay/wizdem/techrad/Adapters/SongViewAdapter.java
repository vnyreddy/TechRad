package com.vinay.wizdem.techrad.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.vinay.wizdem.techrad.Activities.OpenYouTubePlayerActivity;
import com.vinay.wizdem.techrad.Activities.SongViewActivity;
import com.vinay.wizdem.techrad.R;
import com.vinay.wizdem.techrad.Utils.Utils;

import static android.content.ContentValues.TAG;

/**
 * Created by vinay_1 on 6/8/2017.
 */

public class SongViewAdapter extends RecyclerView.Adapter<SongViewAdapter.MyViewHolder> {

    public static int adapter_position;

    public SongViewAdapter(int position) {
        this.adapter_position = position;
         }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) throws RuntimeException {
        // Create view object
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_view_row, parent, false);

        MyViewHolder holder = new MyViewHolder(view);
        //then return view
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Uri uri = Uri.parse(Utils.modelData.getStatuses().get(adapter_position).getSongs().get(position).getThumbNailIcon());
        //set data on text views form model class
        try {
            holder.thumb_nail.setImageURI(uri);
            holder.song_name.setText(Utils.modelData.getStatuses().get(adapter_position).getSongs().get(position).getSongName());
            holder.song_owner.setText(Utils.modelData.getStatuses().get(adapter_position).getSongs().get(position).getOwner());
            holder.song_views.setText(Utils.modelData.getStatuses().get(adapter_position).getSongs().get(position).getViews());

        }catch (RuntimeException e){
            Log.e(TAG, "onBindViewHolder: ",e );
        }

    }

    @Override
    public int getItemCount() {
        return Utils.modelData.getStatuses().get(adapter_position).getSongs().size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView thumb_nail;
        TextView song_name, song_owner, song_views;


        public MyViewHolder(View itemView) {
            super(itemView);
            thumb_nail = (ImageView) itemView.findViewById(R.id.thumb_nail_image_view);
            song_name = (TextView) itemView.findViewById(R.id.song_name);
            song_owner = (TextView) itemView.findViewById(R.id.song_owner);
            song_views = (TextView) itemView.findViewById(R.id.song_views);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String API_KEY = "AIzaSyD--Hz_BxdftFqZdoe8AAZ8tqOLVBvxWC4";
                    Context context = view.getContext();
                    Intent intent = new Intent( context, OpenYouTubePlayerActivity.class);
                    intent.putExtra("CHANNEL_POSITION", adapter_position);
                    intent.putExtra("SONG_POSITION",getAdapterPosition());
                    context.startActivity(intent);

                    /*Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity) context, "AIzaSyD--Hz_BxdftFqZdoe8AAZ8tqOLVBvxWC4", "WkFI_3w7dVQ");
                    context.startActivity(intent);*/
                   /* YouTubePlayerView youTubePlayerView = (YouTubePlayerView) view.findViewById(R.id.youtube_player_view);
                    youTubePlayerView.initialize(API_KEY, (YouTubePlayer.OnInitializedListener) context);
*/

                }
            });
        }

        @Override
        public String toString() {
            return super.toString();
        }

    }
}
