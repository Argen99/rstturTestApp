package com.example.domain.repository

import com.example.domain.models.blog_info.BlogInfoModel
import com.example.domain.models.content_response.ContentModel
import com.example.domain.models.main_response.MainDataModel
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    suspend fun getMainData(): MainDataModel
    suspend fun getContent(url: String): List<ContentModel>
    fun getBlogInfo(blogId: Int): Flow<BlogInfoModel>
}