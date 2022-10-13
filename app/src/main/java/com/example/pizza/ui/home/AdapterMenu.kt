package com.example.pizza.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizza.DataPizza
import com.example.pizza.databinding.ItemPizzaBinding

class AdapterMenu(private val dataSet: List<DataPizza>):
    RecyclerView.Adapter<AdapterMenu.ViewHolder>() {

    class ViewHolder(private val binding: ItemPizzaBinding) :
        RecyclerView.ViewHolder(binding.root) {
         fun bind(data: DataPizza) {
            binding.title.text = data.title
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
