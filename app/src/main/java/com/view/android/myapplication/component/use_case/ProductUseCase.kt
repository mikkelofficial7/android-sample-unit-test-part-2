package com.view.android.myapplication.component.use_case

import com.view.android.myapplication.component.repository.ProductRepository
import com.view.android.myapplication.core.state.NetworkState

class ProductUseCaseImpl(val repository: ProductRepository): ProductUseCase {
    override suspend fun getAllProduct(): NetworkState {
        return repository.getAllProduct()
    }
}

interface ProductUseCase {
    suspend fun getAllProduct(): NetworkState
}