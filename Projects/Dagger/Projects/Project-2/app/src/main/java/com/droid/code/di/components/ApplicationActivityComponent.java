package com.droid.code.di.components;


import com.droid.code.di.modules.ActivityModule;
import com.droid.code.ui.MainActivity;

import dagger.Component;

@Component(modules = {ActivityModule.class})
public interface ApplicationActivityComponent {
    void inject(MainActivity activity);
}
