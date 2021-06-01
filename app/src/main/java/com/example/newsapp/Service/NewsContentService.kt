package com.example.newsapp.Service

import com.example.newsapp.models.NewsContentResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface NewsContentInterfaceService {

    @GET("/v2/top-headlines")
    fun getNewsContent(
        @Query("country") country: String, @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Single<NewsContentResponse>
}

class NewsContentService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    val service  : NewsContentInterfaceService =  retrofit.create(NewsContentInterfaceService::class.java)
}


