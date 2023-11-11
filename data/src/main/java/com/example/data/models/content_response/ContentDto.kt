package com.example.data.models.content_response

import com.example.data.utils.DataMapper
import com.example.domain.models.content_response.ContentModel

data class ContentDto(
    val id: Int,
    val image: ImageDto,
    val title: String?,
    val subtitle: String?,
    val view: Int,
    val like: Int,
    val date: DateDto?
) : DataMapper<ContentModel> {

    override fun toDomain() = ContentModel(
        id = id,
        image = image.toDomain(),
        title = title,
        subtitle = subtitle,
        view = view,
        like = like,
        date = date?.toDomain(),
    )
}