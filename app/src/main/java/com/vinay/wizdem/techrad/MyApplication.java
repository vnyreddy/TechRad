package com.vinay.wizdem.techrad;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by vinay_1 on 6/10/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
