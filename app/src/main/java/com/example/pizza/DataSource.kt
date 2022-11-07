package com.example.pizza


data class DataPizza(val title: String,  val description: String,val price: Int)
data class DataCategory(val category: String)


class DataSource {
    private val dataList = listOf(
        DataPizza("Ветчина и грибы", "Ветчина, шампиньоны, грибы, увеличенная порция моцареллы, томатный соус", 202),
        DataPizza("Ветчина и грибы", "Ветчина, шампиньоны, грибы, увеличенная порция моцареллы, томатный соус", 202),
        DataPizza("Ветчина и грибы", "Ветчина, шампиньоны, грибы, увеличенная порция моцареллы, томатный соус", 202),
        DataPizza("Ветчина и грибы", "Ветчина, шампиньоны, грибы, увеличенная порция моцареллы, томатный соус", 202),
        DataPizza("Ветчина и грибы", "Ветчина, шампиньоны, грибы, увеличенная порция моцареллы, томатный соус", 202),
    )
    private val categoryList= listOf(
        DataCategory("Пицца"),
        DataCategory("Комбо"),
        DataCategory("Десерты"),
        DataCategory("Напитки"),
        DataCategory("Пицца"),
    )

    fun getPizzaList(): List<DataPizza> {
        return dataList
    }
    fun getCategoryList(): List<DataCategory>{
        return categoryList
    }
}