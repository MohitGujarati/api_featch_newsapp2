package com.example.api_featch_newsapp2.Apis

import com.example.api_featch_newsapp2.Model.Article_model
import com.example.api_featch_newsapp2.Model.main_model
import retrofit2.http.GET


const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "Enter you api key"
const val NEWS_API = "v2/top-headlines?country=in&apiKey=$API_KEY"


interface Api_Interface {

    @GET(NEWS_API)
    fun getnew():retrofit2.Call<main_model>

}
