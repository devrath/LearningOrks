package com.droid.code;

import android.app.Application;
import android.util.Log;

import com.droid.code.data.local.DatabaseService;
import com.droid.code.data.remote.NetworkService;
import com.droid.code.di.components.ApplicationComponent;
import com.droid.code.di.components.DaggerApplicationComponent;
import com.droid.code.di.modules.ApplicationModule;

import javax.inject.Inject;


public class MyApplication extends Application {

    @Inject
    public NetworkService networkService;

    @Inject
    public DatabaseService databaseService;


    public ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // ---> This is used to store a application level instance
        // And later we can use it in activity to create activity level instances

        // ---> This is used for creation of application level instances
        applicationComponent =  DaggerApplicationComponent.builder()
                // Module object creation
                .applicationModule(new ApplicationModule(this))
                // Building the modules
                .build();

        applicationComponent.inject(this);

        Log.d("Tag","Dependencies Added");
    }
}