package com.view.android.myapplication.component.use_case

import com.view.android.myapplication.component.repository.ProductRepository
import com.view.android.myapplication.core.state.NetworkState

class ProductUseCaseImpl(val repository: ProductRepository): ProductUseCase {
    override suspend fun getAllProduct(): NetworkState {
        return repository.getAllProduct()
    }

    override suspend fun getAllProductFromDb(): NetworkState {
        return repository.getAllProductFromDB()
    }
}

interface ProductUseCase {
    suspend fun getAllProduct(): NetworkState
    suspend fun getAllProductFromDb(): NetworkState
}