package com.droid.code;

import android.app.Application;
import com.droid.code.data.local.DatabaseService;
import com.droid.code.data.remote.NetworkService;

import javax.inject.Inject;


public class MyApplication extends Application {

    @Inject
    public NetworkService networkService;

    @Inject
    public DatabaseService databaseService;

    @Override
    public void onCreate() {
        super.onCreate();
        //DependencyComponent.inject(this);
    }
}