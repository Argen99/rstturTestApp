package com.example.data.models

import com.example.data.models.main_response.ErrorDto

data class BaseResponse<T>(
    val success: Boolean,
    val error: ErrorDto?,
    val time: String,
    val data: T
)