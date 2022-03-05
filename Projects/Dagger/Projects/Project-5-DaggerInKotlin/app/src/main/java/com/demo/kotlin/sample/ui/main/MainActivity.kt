package com.demo.kotlin.sample.ui.main

import android.os.Bundle
import android.widget.TextView

import com.demo.kotlin.sample.MyApplication
import com.demo.kotlin.sample.R
import com.demo.kotlin.sample.di.component.DaggerActivityComponent
import com.demo.kotlin.sample.di.module.ActivityModule
import com.demo.kotlin.sample.ui.home.HomeFragment

import javax.inject.Inject

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvData = findViewById<TextView>(R.id.tv_message)
        tvData.text = viewModel.someData

        addHomeFragment()
    }

    private fun addHomeFragment() {
        if (supportFragmentManager.findFragmentByTag(HomeFragment.TAG) == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container_fragment, HomeFragment.newInstance(), HomeFragment.TAG)
                    .commit()
        }
    }

    private fun getDependencies() {
        DaggerActivityComponent
                .builder()
                .applicationComponent((application as MyApplication).applicationComponent)
                .activityModule(ActivityModule(this))
                .build()
                .inject(this)
    }
}
