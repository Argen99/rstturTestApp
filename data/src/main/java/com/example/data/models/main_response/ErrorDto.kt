package com.example.data.models.main_response

import com.example.data.utils.DataMapper
import com.example.domain.models.main_response.ErrorModel

data class ErrorDto(
    val name: String,
    val status: String,
    val code: String,
    val message: String
) : DataMapper<ErrorModel> {
    override fun toDomain() = ErrorModel(
        name = name,
        status = status,
        code = code,
        message = message
    )
}
