package com.example.newsapp.Adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.Views.MainActivity
import com.example.newsapp.databinding.ItemCardViewBinding
import com.example.newsapp.viewmodel.ItemCardViewModel

class NewsContentAdaptor(
    val itemCardViewModels: ArrayList<ItemCardViewModel>,
    mainActivity: MainActivity
) :
    RecyclerView.Adapter<NewsContentViewHolder>() {
  //  var itemCardViewModelList = mutableListOf<ItemCardViewModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsContentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardViewBinding.inflate(inflater, parent, false)
        return NewsContentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsContentViewHolder, position: Int) {
        val itemCardViewModel = itemCardViewModels[position]
        holder.bind(itemCardViewModel)
    }
    override fun getItemCount(): Int {
       return itemCardViewModels.size
    }

}