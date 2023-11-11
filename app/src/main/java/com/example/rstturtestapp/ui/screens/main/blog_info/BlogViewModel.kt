package com.example.rstturtestapp.ui.screens.main.blog_info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.blog_info.BlogInfoModel
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BlogViewModel(
    private val repository: MainRepository
) : ViewModel() {

    private val _blogState = MutableStateFlow<BlogInfoModel?>(null)
    val blogState = _blogState.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    fun getBlogInfo(blogId: Int) {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            repository.getBlogInfo(blogId).collect {
                _blogState.value = it
                _isLoading.value = false
            }
        }
    }
}