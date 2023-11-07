package com.example.rstturtestapp.ui.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.main_response.MainResponseModel
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MainRepository
): ViewModel() {

    private val _mainState = MutableLiveData<MainResponseModel>()
    val mainState: LiveData<MainResponseModel> = _mainState

    init {
        fetchCreditCards()
    }

    fun fetchCreditCards() {
        viewModelScope.launch {
            try {
                val cards = repository.getMainData()
                _mainState.value = cards
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}