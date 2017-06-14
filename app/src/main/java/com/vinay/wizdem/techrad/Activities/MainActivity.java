package com.vinay.wizdem.techrad.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vinay.wizdem.techrad.Adapters.MyAdapter;
import com.vinay.wizdem.techrad.Models.Example;
import com.vinay.wizdem.techrad.Models.Status;
import com.vinay.wizdem.techrad.R;
import com.vinay.wizdem.techrad.Utils.Utils;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "http://techradicle.com/api/songsTypes/fetchCategories";
    private RequestQueue mRequestQueue;
    private TextView mTextview;
    private Gson gson;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
     //   mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mTextview = (TextView)findViewById(R.id.label);

        // Get gson object
        gson = new GsonBuilder().setPrettyPrinting().create();

        //Instantiate Queue Request
        mRequestQueue = Volley.newRequestQueue(this);

        //Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET,URL, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                //Display response to the string
             //   mTextView.setText("Response:" + response);
                //read json data from the resoponse string
                String data = new String(response);
                //parsing json string to object
                Utils.modelData = gson.fromJson(data, Example.class);
              //  List<Example> list = Arrays.asList(gson.fromJson(data, Example[].class));

//                mTextview.setText(Utils.modelData.getStatuses().get(1).getSongs().get(2).getSongName().toString());

                // specify an adapter (see also next example)
                mAdapter = new MyAdapter(Utils.modelData);
                mRecyclerView.setAdapter(mAdapter);
            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                mTextview.setText("URL didn't work");

            }
        }
        );

        //Add request to the string
        mRequestQueue.add(stringRequest);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mRequestQueue != null){
            mRequestQueue.cancelAll(this);
        }
    }
}
