package com.tools.meetsi.di


import com.tools.meetsi.repository.MainRepository
import com.tools.meetsi.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    single { MainRepository(get()) }
    viewModel { MainViewModel(get()) }

}
