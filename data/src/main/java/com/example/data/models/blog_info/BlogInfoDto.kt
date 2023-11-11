package com.example.data.models.blog_info

import com.example.data.models.content_response.ImageDto
import com.example.data.utils.DataMapper
import com.example.domain.models.blog_info.BlogInfoModel

data class BlogInfoDto(
    val id: Int,
    val url: String,
    val image: ImageDto,
    val title: String,
    val subtitle: String,
    val like: Int,
    val date: String,
    val content: String
) : DataMapper<BlogInfoModel> {

    override fun toDomain() = BlogInfoModel(
        id = id,
        url = url,
        image = image.toDomain(),
        title = title,
        subtitle = subtitle,
        like = like,
        date = date,
        content = content,
    )
}