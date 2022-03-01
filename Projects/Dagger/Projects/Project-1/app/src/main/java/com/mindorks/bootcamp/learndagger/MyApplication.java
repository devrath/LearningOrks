package com.mindorks.bootcamp.learndagger;

import android.app.Application;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;

import javax.inject.Inject;


/**
 * This is the dependency consumer
 * It has to ask the dagger for the dependencies
 */
public class MyApplication extends Application {

    // Inject annotation helps dagger to identify the dependencies it has to provide
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