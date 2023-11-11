package com.example.rstturtestapp.ui.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.content_response.ContentModel
import com.example.domain.models.main_response.MainDataModel
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MainRepository
) : ViewModel() {

    private val _mainState = MutableLiveData<MainDataModel>()
    val mainState: LiveData<MainDataModel> = _mainState

    private val _contentState = MutableLiveData<MutableMap<String, List<ContentModel>>>()
    val contentState: LiveData<MutableMap<String, List<ContentModel>>> = _contentState

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        getMainData()
    }

    private fun getMainData() {
        viewModelScope.launch {
            try {
                val cards = repository.getMainData()
                _mainState.value = cards
                val list = mutableMapOf<String, List<ContentModel>>()
                cards.content.forEach {
                    val res = repository.getContent(it.url)
                    list[it.title] = res
                }
                _contentState.value = list
                _isLoading.value = false
            } catch (e: Exception) {
                _isLoading.value = false
            }
        }
    }
}