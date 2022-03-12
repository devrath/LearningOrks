package com.demo.code.instagram.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.demo.code.instagram.InstagramApplication
import com.demo.code.instagram.di.component.ActivityComponent
import com.demo.code.instagram.di.component.DaggerActivityComponent
import com.demo.code.instagram.di.module.ActivityModule
import com.demo.code.instagram.utils.display.Toaster
import javax.inject.Inject

/**
 * Reference for generics: https://kotlinlang.org/docs/reference/generics.html
 * Basically BaseActivity will take any class that extends BaseViewModel
 *
 * Every activity needs a view model so lets pass view model as the generic parameter
 * Also making sure the generic type is always base view model or something that inherits base-view-model
 */
abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        // This solves many production bugs, So better to prepare the dependency needed before onCreate is called
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setupObservers()
        setupView(savedInstanceState)
        viewModel.onCreate()
    }

    private fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as InstagramApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()

    /**
     * Certain observers that are needed in all the activities
     */
    protected open fun setupObservers() {
        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
    }

    /** ******* Here we show user a notification as some message ******* **/
    fun showMessage(message: String) = Toaster.show(applicationContext, message)

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))
    /** *************************************************************** **/

    open fun goBack() = onBackPressed()

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStackImmediate()
        else super.onBackPressed()
    }

    /** ******************* Abstract methods ******************* **/
    /**
     * This util function helps to pass layout resource as a function
     * I can mention @LayoutRes so that the function only accepts layout as a resource
     */
    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

    protected abstract fun setupView(savedInstanceState: Bundle?)
    /** ******************* Abstract methods ******************* **/
}