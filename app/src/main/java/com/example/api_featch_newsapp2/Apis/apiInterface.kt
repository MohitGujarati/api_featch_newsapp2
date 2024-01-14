package com.example.api_featch_newsapp2.Apis

import com.example.api_featch_newsapp2.Model.main_model
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "6566c770e39349c1b7f924d0bc85a62f"
const val NEWS_API = "v2/top-headlines?country=in&apiKey=$API_KEY"


interface apiInterface {

    @GET(NEWS_API)
    fun getNews():retrofit2.Call<main_model>

}
