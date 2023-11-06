package com.example.data.models

import com.example.data.utils.DataMapper
import com.example.domain.models.ContentModel

data class ContentDto(
    val title: String,
    val template: TemplateDto,
    val url: String,
) : DataMapper<ContentModel> {
    override fun toDomain() = ContentModel(
        title = title,
        template = template.toDomain(),
        url = url,
    )
}
