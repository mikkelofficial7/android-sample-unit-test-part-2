package com.view.android.myapplication.core.state

sealed class NetworkState {
    data object Loading: NetworkState()
    data class Success<T>(val result: T): NetworkState()
    data object Failed: NetworkState()
}