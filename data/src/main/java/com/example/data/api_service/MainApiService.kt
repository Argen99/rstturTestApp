package com.example.data.api_service

import com.example.data.models.BaseListResponse
import com.example.data.models.BaseResponse
import com.example.data.models.blog_info.BlogInfoDto
import com.example.data.models.content_response.ContentDto
import com.example.data.models.main_response.MainDataDto
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MainApiService {

    @GET("base-app/main")
    suspend fun getMainData(
        @Query("id") id: Int = ID
    ): BaseResponse<MainDataDto>

    @GET
    suspend fun getContent(
        @Url url: String
    ): BaseListResponse<ContentDto>

    @GET("base-app/blog-info")
    suspend fun getBlogInfo(
        @Query("id") id: Int = ID,
        @Query("blog_id") blogId: Int,
    ): BaseResponse<BlogInfoDto>

    companion object {
        const val ID = 117
    }
}