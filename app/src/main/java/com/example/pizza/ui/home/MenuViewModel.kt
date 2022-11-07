package com.example.pizza.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pizza.DataCategory
import com.example.pizza.DataPizza

class MenuViewModel (private val dataFromDataBase: DataNetworkInteract) :
    ViewModel() {
    val loadingListPizza = MutableLiveData<List<DataPizza>>()
    val loadingListCategory = MutableLiveData<List<DataCategory>>()
    fun onViewCreatedPizza() {
        val listPizzaResponse = dataFromDataBase.dataNetworkInteract
        loadingListPizza.postValue(listPizzaResponse)
        val listCategoryResponse = dataFromDataBase.dataCategory
        loadingListCategory.postValue(listCategoryResponse)
    }
}

@Suppress("UNCHECKED_CAST")
class PizzaListViewModelFactory(
    private val interact: DataNetworkInteract
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MenuViewModel(interact) as T
}