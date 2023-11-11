package com.example.data.models

import com.example.data.models.main_response.ErrorDto

data class BaseListResponse<T>(
    val success: Boolean,
    val error: ErrorDto?,
    val time: String,
    val data: List<T>
)