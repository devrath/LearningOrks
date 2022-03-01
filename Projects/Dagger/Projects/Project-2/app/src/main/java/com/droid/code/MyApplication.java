package com.droid.code;

import android.app.Application;
import com.droid.code.data.local.DatabaseService;
import com.droid.code.data.remote.NetworkService;
import com.droid.code.di.components.DaggerApplicationComponent;
import com.droid.code.di.modules.ApplicationModule;

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

        DaggerApplicationComponent.builder()
                // Module object creation
                .applicationModule(new ApplicationModule(this))
                // Building the modules
                .build()
                // Injecting to the classes
                .inject(this);
    }
}