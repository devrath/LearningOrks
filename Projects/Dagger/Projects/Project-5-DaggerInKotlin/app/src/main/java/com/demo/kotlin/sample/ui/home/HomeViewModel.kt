package com.demo.kotlin.sample.ui.home

import com.demo.kotlin.sample.data.local.DatabaseService
import com.demo.kotlin.sample.data.remote.NetworkService
import com.demo.kotlin.sample.di.FragmentScope
import com.demo.kotlin.sample.utils.NetworkHelper

import javax.inject.Inject

@FragmentScope
class HomeViewModel @Inject constructor(
        private val databaseService: DatabaseService,
        private val networkService: NetworkService,
        private val networkHelper: NetworkHelper) {

    val someData: String
        get() = (databaseService.dummyData
                + " : " + networkService.dummyData
                + " : " + networkHelper.isNetworkConnected)
}
