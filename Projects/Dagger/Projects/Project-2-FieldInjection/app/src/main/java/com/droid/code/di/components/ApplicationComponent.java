package com.droid.code.di.components;

import com.droid.code.MyApplication;
import com.droid.code.data.local.DatabaseService;
import com.droid.code.data.remote.NetworkService;
import com.droid.code.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);

    NetworkService getNetworkService();

    DatabaseService getDatabaseService();

}
