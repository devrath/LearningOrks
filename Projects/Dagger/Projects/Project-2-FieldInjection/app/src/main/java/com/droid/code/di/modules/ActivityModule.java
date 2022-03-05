package com.droid.code.di.modules;

import android.app.Activity;
import android.content.Context;

import com.droid.code.data.local.DatabaseService;
import com.droid.code.data.remote.NetworkService;
import com.droid.code.ui.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity context;

    public ActivityModule(Activity context){
        this.context = context;
    }

    @Provides
    MainViewModel providesMainViewModule(DatabaseService databaseService,
                                         NetworkService networkService) {
        return new MainViewModel(databaseService,networkService);
    }

}
