package com.example.data.models

import com.example.data.utils.DataMapper
import com.example.domain.models.MainResponseModel

data class MainResponseDto(
    val success: Boolean,
    val error: ErrorDto?,
    val time: String,
    val data: MainDataDto
) : DataMapper<MainResponseModel> {
    override fun toDomain() = MainResponseModel(
        success = success,
        error = error?.toDomain(),
        time = time,
        data = data.toDomain(),
    )
}
