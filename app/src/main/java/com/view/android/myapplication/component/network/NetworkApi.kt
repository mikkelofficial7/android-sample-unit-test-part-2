package com.view.android.myapplication.component.network

import com.view.android.myapplication.component.model.ProductResponse
import retrofit2.http.GET

interface NetworkApi {
    @GET("products")
    suspend fun listAllProduct(): ProductResponse?
}