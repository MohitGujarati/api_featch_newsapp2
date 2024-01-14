package com.example.api_featch_newsapp2.Apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroObject {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getapi by lazy {
        retrofit.create(apiInterface::class.java)
    }


}