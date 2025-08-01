package com.view.android.myapplication.component.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideRetrofitCreate(retrofit: Retrofit): NetworkApi? {
        return retrofit.create(NetworkApi::class.java)
    }
}