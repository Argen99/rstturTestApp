package com.example.domain.repository

import com.example.domain.models.main_response.MainResponseModel

interface MainRepository {

    suspend fun getMainData(): MainResponseModel
}