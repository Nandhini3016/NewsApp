package com.example.newsapp.models

data class NewsContentResponse(val status : String,
                               val totalResults : Int,
                               val articles : List<ArticleResponse>)
