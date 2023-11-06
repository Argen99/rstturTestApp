package com.example.data.models

data class MainResponseDto(
    val success: Boolean,
    val error: ErrorDto?,
    val time: String,
    val data: MainDataDto
)
