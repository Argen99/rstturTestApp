package com.example.data.models.content_response

import com.example.data.models.main_response.ErrorDto
import com.example.data.utils.DataMapper
import com.example.domain.models.content_response.ContentModel
import com.example.domain.models.content_response.ContentResponseModel

data class ContentResponseDto(
    val success: Boolean,
    val error: ErrorDto?,
    val time: String,
    val data: List<ContentDto>
) : DataMapper<ContentResponseModel> {

    override fun toDomain() = ContentResponseModel(
        success = success,
        error = error?.toDomain(),
        time = time,
        data = data.map { it.toDomain() }
    )
}
