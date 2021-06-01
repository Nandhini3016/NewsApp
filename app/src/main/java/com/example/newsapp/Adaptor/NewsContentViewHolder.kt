package com.example.newsapp.Adaptor

import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ItemCardViewBinding
import com.example.newsapp.viewmodel.ItemCardViewModel

class NewsContentViewHolder(val binding: ItemCardViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(itemCardViewModel: ItemCardViewModel) {
        binding.itemViewModel = itemCardViewModel
       binding.executePendingBindings()
    }
}
