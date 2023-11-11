package com.example.domain.models.blog_info

import com.example.domain.models.content_response.ImageModel

data class BlogInfoModel(
    val id: Int,
    val url: String,
    val image: ImageModel,
    val title: String,
    val subtitle: String,
    val like: Int,
    val date: String,
    val content: String
)