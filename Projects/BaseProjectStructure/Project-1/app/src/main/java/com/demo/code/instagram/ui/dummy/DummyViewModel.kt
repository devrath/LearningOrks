package com.demo.code.instagram.ui.dummy

import com.demo.code.instagram.data.repository.DummyRepository
import com.demo.code.instagram.ui.base.BaseViewModel
import com.demo.code.instagram.utils.network.NetworkHelper
import com.demo.code.instagram.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable


class DummyViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val dummyRepository: DummyRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    override fun onCreate() {
        // do something
    }
}