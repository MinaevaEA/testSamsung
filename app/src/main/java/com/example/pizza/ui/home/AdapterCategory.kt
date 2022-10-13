package com.example.pizza.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizza.DataCategory
import com.example.pizza.databinding.ItemCategoryBinding

class AdapterCategory(private val dataCategory: List<DataCategory>) :
    RecyclerView.Adapter<AdapterCategory.MyViewHolder>() {

    class MyViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataCategory) {
            binding.title.text = data.category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataCategory[position])
    }

    override fun getItemCount() = dataCategory.size

}

