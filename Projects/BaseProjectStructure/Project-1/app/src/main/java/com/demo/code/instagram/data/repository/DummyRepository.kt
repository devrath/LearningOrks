package com.demo.code.instagram.data.repository

import com.demo.code.instagram.data.local.db.DatabaseService
import com.demo.code.instagram.data.model.Dummy
import com.demo.code.instagram.data.remote.NetworkService
import com.demo.code.instagram.data.remote.request.DummyRequest
import io.reactivex.Single
import javax.inject.Inject

class DummyRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {

    fun fetchDummy(id: String): Single<List<Dummy>> =
        networkService.doDummyCall(DummyRequest(id)).map { it.data }

}