package com.example.data.models

import com.example.data.utils.DataMapper
import com.example.domain.models.ErrorModel

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
