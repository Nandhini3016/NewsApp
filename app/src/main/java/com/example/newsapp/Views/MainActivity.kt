package com.example.newsapp.Views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.Adaptor.NewsContentAdaptor
import com.example.newsapp.R
import com.example.newsapp.viewmodel.HomeViewModel
import com.example.newsapp.viewmodel.ItemCardViewModel
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(),LifecycleObserver {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //supportActionBar?.setCustomView(R.layout.toolbar)
        val binding  = DataBindingUtil.setContentView<com.example.newsapp.databinding.ActivityMainBinding>(this, R.layout.activity_main)
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        lifecycle.addObserver(this)
        homeViewModel.getValue()
       /*binding.idRecyclerview.adapter = homeViewModel.setAdaptor()
        binding.idRecyclerview.layoutManager = LinearLayoutManager(this.application)*/


        homeViewModel.itemCardViewModelListLiveData.observe(this,
        Observer<ArrayList<ItemCardViewModel>> {
            itemCardViewModels ->
            val adapter = NewsContentAdaptor(itemCardViewModels, this@MainActivity)
            binding.idRecyclerview.layoutManager = LinearLayoutManager(applicationContext)
            binding.idRecyclerview.adapter = adapter
        })

    }
}
