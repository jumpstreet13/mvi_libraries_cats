package com.example.mvi_examples.mvilibraries

import io.reactivex.Single
import retrofit2.http.GET

interface CatsService {

    @GET("images/search?limit=50&page=1&order=Desc")
    fun getKitties(): Single<List<Cat>>

    @GET("images/search?limit=50&page=1&order=Desc")
    suspend fun getKittiesSuspend(): List<Cat>
}