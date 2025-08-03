package com.view.android.myapplication.component.repository

import com.view.android.myapplication.component.network.NetworkApi
import com.view.android.myapplication.component.model.ProductResponse
import com.view.android.myapplication.component.room.AppDatabase
import com.view.android.myapplication.component.room.RoomConfig
import com.view.android.myapplication.core.state.NetworkState
import retrofit2.HttpException

class ProductRepositoryImpl(val api: NetworkApi, val db: AppDatabase): ProductRepository {
    override suspend fun getAllProduct(): NetworkState {
        try {
            val result = api.listAllProduct() ?: ProductResponse()
            return NetworkState.Success(result)
        } catch (e: HttpException) {
            return NetworkState.Failed
        }
    }

    override suspend fun getAllProductFromDB(): NetworkState {
        try {
            val result = db.productDao().getAll()
            return NetworkState.Success(result)
        } catch (e: HttpException) {
            return NetworkState.Failed
        }
    }
}

interface ProductRepository {
    suspend fun getAllProduct(): NetworkState
    suspend fun getAllProductFromDB(): NetworkState
}