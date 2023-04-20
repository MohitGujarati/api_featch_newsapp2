package com.example.api_featch_newsapp2.Model

data class Article_model(
    val source: Source,
    val content: String,
    val author: String,
    val title: String,
    val publishedAt: String,
    val description: String,
    val url: String,
    val urlToImage: String
)

data class Source (
    val id: String? = null,
    val name: String? = null
)