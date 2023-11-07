package com.example.data.repository

import com.example.data.api_service.MainApiService
import com.example.domain.models.main_response.MainResponseModel
import com.example.domain.repository.MainRepository

class MainRepositoryImpl(
    private val apiService: MainApiService
): MainRepository {

    override suspend fun getMainData(): MainResponseModel {
        return apiService.getMainData().toDomain()
    }
}