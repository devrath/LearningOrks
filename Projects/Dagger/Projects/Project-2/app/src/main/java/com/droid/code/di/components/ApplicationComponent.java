package com.droid.code.di.components;

import com.droid.code.MyApplication;
import com.droid.code.di.modules.ApplicationModule;

import dagger.Component;


/**
 * The component class:
 * Takes a array of modules that is needed for our application to work.
 */

/**
 * Dagger appends:
 * The class with dagger key and implements the method mentioned in it
 */

/**
 * Role of the component:
 * Is to provide such classes that needs to be scanned for the inject mechanisms
 */

@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);


}
