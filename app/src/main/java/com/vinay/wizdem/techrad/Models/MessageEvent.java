package com.vinay.wizdem.techrad.Models;

/**
 * Created by vinay_1 on 6/19/2017.
 */

public class MessageEvent {
    public int myAdapter_position;
    public int songViewAdapter_position;
    public MessageEvent(int myAdapter_position, int songViewAdapter_position){
        this.myAdapter_position = myAdapter_position;
        this.songViewAdapter_position = songViewAdapter_position;
    }
}
