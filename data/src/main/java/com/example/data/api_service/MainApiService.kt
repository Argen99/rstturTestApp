package com.example.data.api_service

import com.example.domain.models.content_response.ContentResponseModel
import com.example.data.models.main_response.MainResponseDto
import retrofit2.http.GET
import retrofit2.http.Url

interface MainApiService {

    @GET("base-app/main?id=117")
    suspend fun getMainData(): MainResponseDto

    @GET
    suspend fun getContent(
        @Url url: String
    ): ContentResponseModel
}