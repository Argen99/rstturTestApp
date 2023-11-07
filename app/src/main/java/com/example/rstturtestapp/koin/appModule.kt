package com.example.rstturtestapp.koin

import org.koin.androidx.viewmodel.dsl.viewModelOf
import com.example.rstturtestapp.ui.screens.main.MainViewModel
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::MainViewModel)
}