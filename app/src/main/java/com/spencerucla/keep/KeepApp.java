package com.spencerucla.keep;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

public class KeepApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }
}
