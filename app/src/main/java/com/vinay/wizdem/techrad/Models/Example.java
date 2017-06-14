package com.vinay.wizdem.techrad.Models;

/**
 * Created by vinay_1 on 6/3/2017.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example implements Serializable{

    @SerializedName("status")
    @Expose
    private ArrayList<Status> status;

    public ArrayList<Status> getStatuses() {
        return status;
    }

    public void setStatuses(ArrayList<Status> status) {
        this.status = status;
    }
}
