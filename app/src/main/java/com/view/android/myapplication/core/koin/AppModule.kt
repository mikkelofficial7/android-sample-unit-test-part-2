package com.view.android.myapplication.core.koin
import com.view.android.myapplication.component.repository.ProductRepository
import com.view.android.myapplication.component.repository.ProductRepositoryImpl
import com.view.android.myapplication.component.use_case.ProductUseCase
import com.view.android.myapplication.component.use_case.ProductUseCaseImpl
import com.view.android.myapplication.component.viewmodel.MainViewModel
import com.view.android.myapplication.component.network.NetworkConfig
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { NetworkConfig.provideRetrofit() }
    single { NetworkConfig.provideRetrofitCreate(get()) }
}

val repoModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get()) }
}

val useCaseModule = module {
    single<ProductUseCase> { ProductUseCaseImpl(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}