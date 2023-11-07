package com.example.data.models.main_response

import com.example.data.utils.DataMapper
import com.example.domain.models.main_response.ContentInfoModel

data class ContentInfoDto(
    val title: String,
    val template: TemplateDto,
    val url: String,
) : DataMapper<ContentInfoModel> {
    override fun toDomain() = ContentInfoModel(
        title = title,
        template = template.toDomain(),
        url = url,
    )
}
