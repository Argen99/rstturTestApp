package com.example.data.models.content_response

import com.example.data.utils.DataMapper
import com.example.domain.models.content_response.DateModel

data class DateDto(
    val typeDate: String?,
    val date: String?
) : DataMapper<DateModel> {

    override fun toDomain() = DateModel(
        typeDate = typeDate,
        date = date
    )
}
