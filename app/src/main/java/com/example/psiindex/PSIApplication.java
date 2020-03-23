package com.example.psiindex;

import android.app.Application;

import dagger.android.DispatchingAndroidInjector;

public class PSIApplication extends Application {
    DispatchingAndroidInjector dispatchingAndroidInjector;
    @Override
    public void onCreate() {

        super.onCreate();

    }
}
