package com.example.mvi_examples.mvilibraries

import com.example.mvi_examples.mvilibraries.Cat
import io.reactivex.Single
import retrofit2.http.GET

interface CatsService {

    @GET("images/search?limit=50&page=1&order=Desc")
    fun getKitties(): Single<List<Cat>>
}