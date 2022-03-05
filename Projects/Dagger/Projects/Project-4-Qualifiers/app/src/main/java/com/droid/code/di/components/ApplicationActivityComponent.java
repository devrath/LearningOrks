package com.droid.code.di.components;


import com.droid.code.di.modules.ActivityModule;
import com.droid.code.di.modules.ApplicationModule;
import com.droid.code.di.scope.ActivityScope;
import com.droid.code.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@ActivityScope
@Component(dependencies = {ApplicationComponent.class},modules = {ActivityModule.class})
public interface ApplicationActivityComponent {
    void inject(MainActivity activity);
}
