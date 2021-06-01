package com.example.newsapp.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsapp.Providers.NewsContentProvider
import com.example.newsapp.Service.NewsContentService
import com.example.newsapp.models.ArticleResponse
import com.example.newsapp.models.NewsContentResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel() {
    private val newsContentService = NewsContentService()
    private val newsContentProvider = NewsContentProvider(newsContentService)
    val itemCardViewModelList : kotlin.collections.ArrayList<ItemCardViewModel> = arrayListOf()
    val itemCardViewModelListLiveData : MutableLiveData<ArrayList<ItemCardViewModel>> = MutableLiveData()
    //val adaptor = setAdaptor()

    @BindingAdapter("imageUrl")
    fun loadimage(imageView: ImageView, imageUrl: String?) {
        Glide.with(imageView.context).load(imageUrl).apply(RequestOptions.circleCropTransform())
            .into(imageView)
        //Picasso.with(imageView.getContext()).load(imageUrl).into(imageView);
    }
    fun onSucccess(newsContentResponse: NewsContentResponse) {
        setList(newsContentResponse)
    }

    private fun setList(newsContentResponse: NewsContentResponse) {
        for (i in newsContentResponse.articles.indices) {
            val article: ArticleResponse = newsContentResponse.articles.get(i)

            itemCardViewModelList.add(
                ItemCardViewModel(
                    article.urlToImage,
                    article.title,
                    article.source.name,
                    article.publishedAt
                )
            )
        }
        itemCardViewModelListLiveData.postValue(itemCardViewModelList)
    }

    fun onError(t : Throwable)
    {
        print(">>"+t.message)
    }

    //@OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getValue() {
        newsContentProvider.getNewsContent("us", "business", "668d57badb8b41c297b41cc34194b0c2")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this :: onSucccess, this::onError)

    }

    /*fun setAdaptor(): NewsContentAdaptor {
       // val itemOne = ItemCardViewModel("Hi","Hi","Hi")
        return NewsContentAdaptor(itemCardViewModels, this@MainActivity)
    }*/
}