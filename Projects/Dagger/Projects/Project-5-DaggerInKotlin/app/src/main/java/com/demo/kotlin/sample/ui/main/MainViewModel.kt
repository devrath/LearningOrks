package com.demo.kotlin.sample.ui.main

import com.demo.kotlin.sample.data.local.DatabaseService
import com.demo.kotlin.sample.data.remote.NetworkService
import com.demo.kotlin.sample.di.ActivityScope

import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
        private val databaseService: DatabaseService,
        private val networkService: NetworkService) {

    val someData: String
        get() = databaseService.dummyData + " : " + networkService.dummyData
}
