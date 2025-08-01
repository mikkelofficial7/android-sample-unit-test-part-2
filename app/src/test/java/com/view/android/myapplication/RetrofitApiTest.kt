package com.view.android.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.view.android.myapplication.component.model.ProductResponse
import com.view.android.myapplication.component.repository.ProductRepository
import com.view.android.myapplication.component.use_case.ProductUseCase
import com.view.android.myapplication.component.use_case.ProductUseCaseImpl
import com.view.android.myapplication.component.viewmodel.MainViewModel
import com.view.android.myapplication.core.state.NetworkState
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import kotlin.test.Test

class RetrofitApiTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val repository: ProductRepository = mock()
    private lateinit var useCase: ProductUseCase
    private lateinit var viewModel: MainViewModel

    @Before
    fun init() {
        useCase = ProductUseCaseImpl(repository)
        viewModel = MainViewModel(useCase)
    }

    @Test
    fun retrofitGetAllProductList() = runTest {
        val dummyResponse = ProductResponse()
        whenever(repository.getAllProduct()).thenReturn(NetworkState.Success(dummyResponse))

        viewModel.loadAllProduct()

        viewModel.productData.observeForever { state ->
            println(state)
        }
    }
}