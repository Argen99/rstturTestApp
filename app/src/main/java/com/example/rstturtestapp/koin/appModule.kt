package com.example.rstturtestapp.koin

import com.example.rstturtestapp.ui.screens.main.MainViewModel
import com.example.rstturtestapp.ui.screens.main.blog_info.BlogViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::MainViewModel)
    viewModelOf(::BlogViewModel)
}