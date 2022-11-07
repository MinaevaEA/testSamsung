package com.example.pizza

import android.app.Application

class SubApplication : Application() {
    private lateinit var dataSource: DataSource

    override fun onCreate() {
        super.onCreate()
        dataSource = DataSource()
    }

    fun provideDataSource(): DataSource {
        return dataSource
    }


}