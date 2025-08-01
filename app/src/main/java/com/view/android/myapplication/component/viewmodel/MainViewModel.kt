package com.view.android.myapplication.component.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.view.android.myapplication.component.use_case.ProductUseCase
import com.view.android.myapplication.core.state.NetworkState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    val useCase: ProductUseCase,
): ViewModel() {
    internal val productData = MutableLiveData<NetworkState>()

    fun loadAllProduct() {
       productData.postValue(NetworkState.Loading)
       viewModelScope.launch(Dispatchers.IO) {
           val productList = useCase.getAllProduct()
           productData.postValue(productList)
       }
    }
}