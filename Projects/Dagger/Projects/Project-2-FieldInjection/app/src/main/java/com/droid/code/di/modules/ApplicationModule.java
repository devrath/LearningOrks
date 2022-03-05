package com.droid.code.di.modules;

import android.content.Context;

import com.droid.code.MyApplication;
import com.droid.code.data.local.DatabaseService;
import com.droid.code.data.remote.NetworkService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {

    private MyApplication application;

    public ApplicationModule(MyApplication application) {
        this.application = application;
    }

    @Singleton
    @Provides
    DatabaseService provideDatabaseService() {
        return new DatabaseService(application, "dummy_db", 1);
    }

    @Singleton
    @Provides
    NetworkService provideNetworkService() {
        return new NetworkService(application, "SOME_API_KEY");
    }

}
