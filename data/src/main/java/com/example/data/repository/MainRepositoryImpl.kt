package com.example.data.repository

import com.example.data.api_service.MainApiService
import com.example.domain.models.blog_info.BlogInfoModel
import com.example.domain.models.content_response.ContentModel
import com.example.domain.models.main_response.MainDataModel
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(
    private val apiService: MainApiService
): MainRepository {

    override suspend fun getMainData(): MainDataModel {
        return apiService.getMainData().data.toDomain()
    }

    override suspend fun getContent(url: String): List<ContentModel> {
        return apiService.getContent(url).data.map { it.toDomain() }
    }

    override fun getBlogInfo(blogId: Int): Flow<BlogInfoModel> = flow {
        val res = apiService.getBlogInfo(blogId = blogId)
        emit(res.data.toDomain())
    }
}