package com.vinay.wizdem.techrad.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vinay.wizdem.techrad.Activities.SongViewActivity;
import com.vinay.wizdem.techrad.Models.Example;
import com.vinay.wizdem.techrad.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by vinay_1 on 6/5/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {

//    private List<Example> list = new ArrayList<>();
    private Example mDataset;

    public MyAdapter(Example mDataset) {
        this.mDataset = mDataset;
    }

  /*  public MyAdapter(List<Example> list) {
        this.list = list;
    }*/

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) throws RuntimeException {

        // Create view object
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row, parent, false);
        myViewHolder holder = new myViewHolder(view);
        //then return view
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        //set data on text views form model class
        holder.category.setText(mDataset.getStatuses().get(position).getName());
        try {
            holder.number_of_songs.setText(mDataset.getStatuses().get(position).getCount().toString());
        }catch (RuntimeException e){
            Log.e(TAG, "onBindViewHolder: ",e );
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.getStatuses().size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        private static String ITEM_POSITION;
        //define the view components text and lables
        TextView category, number_of_songs;
        View view;

        public myViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            //initalize variables
            category = (TextView) itemView.findViewById(R.id.catagory);
            number_of_songs = (TextView) itemView.findViewById(R.id.number_of_songs);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context,SongViewActivity.class);
                    intent.putExtra("ITEM_POSITION", getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }

    }

}
