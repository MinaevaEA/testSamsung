package com.example.pizza.ui.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizza.DataPizza
import com.example.pizza.databinding.ItemPizzaBinding

class AdapterMenu :
    RecyclerView.Adapter<AdapterMenu.ViewHolder>() {
    private var dataSet = ArrayList<DataPizza>()

    @SuppressLint("NotifyDataSetChanged")
    fun setDataPizza(newList: List<DataPizza>) {
        dataSet.clear()
        dataSet.addAll(newList)
        Log.d("1","setData")
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemPizzaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataPizza) {
            binding.title.text = data.title
            binding.description.text = data.description
            binding.price.text = data.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPizzaBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

}
