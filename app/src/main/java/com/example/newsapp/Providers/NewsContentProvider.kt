package com.example.newsapp.Providers

import com.example.newsapp.Service.NewsContentInterfaceService
import com.example.newsapp.Service.NewsContentService
import com.example.newsapp.models.NewsContentResponse
import io.reactivex.Single

class NewsContentProvider(val newsContentService: NewsContentService) : NewsContentInterfaceService {
    override fun getNewsContent(
        country: String,
        category: String,
        apiKey : String
    ): Single<NewsContentResponse> {
        return  newsContentService.service.getNewsContent(country, category, apiKey)
    }
}