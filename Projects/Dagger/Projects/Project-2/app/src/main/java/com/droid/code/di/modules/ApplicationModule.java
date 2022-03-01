package com.droid.code.di.modules;

import android.content.Context;

import com.droid.code.MyApplication;
import com.droid.code.data.local.DatabaseService;
import com.droid.code.data.remote.NetworkService;

import dagger.Module;
import dagger.Provides;

/*
 * We need two methods that create and return the instances needed
 * In our case
 * Database Service
 * Network Service
 */

/*
 * There has to be a component that uses this module to provide the instances to the consumer of these dependencies
 */

@Module
public class ApplicationModule {

    private MyApplication context;

    public ApplicationModule(MyApplication context) {
        this.context = context;
    }

    @Provides
    public DatabaseService provideDatabaseService(String databaseName, int version){
        DatabaseService dbService = new DatabaseService(context, databaseName, version);
        return dbService;
    }

    @Provides
    public NetworkService provideNetworkService(String apiKey){
        NetworkService netService = new NetworkService(context,apiKey);
        return netService;
    }

}
