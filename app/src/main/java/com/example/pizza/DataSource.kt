package com.example.pizza


data class DataPizza(val title: String, val price: Int, val description: String)
data class DataCategory(val category: String)


class DataSource {
    private val dataList = listOf(
        DataPizza("Pizza", 200, ""),
        DataPizza("Pizza", 200, "" ),
        DataPizza("Pizza", 200, "" ),
        DataPizza("Pizza", 200, ""),
        DataPizza("Pizza", 200, "" ),
        DataPizza("Pizza", 200, "" ),
        DataPizza("Pizza", 200, "" ),
        DataPizza("Pizza", 200, "" ),
        DataPizza("Pizza", 200, "" ),
        DataPizza("Pizza", 200, "" ),
        DataPizza("Pizza", 200, "" ),
        DataPizza("Pizza", 200, "" )
    )
    private val categoryList= listOf(
        DataCategory("Пицца"),
        DataCategory("Пицца"),
        DataCategory("Пицца"),
        DataCategory("Пицца"),
        DataCategory("Пицца"),
    )



    fun getPizzaList(): List<DataPizza> {
        return dataList
    }
    fun getCategoryList(): List<DataCategory>{
        return categoryList
    }
}