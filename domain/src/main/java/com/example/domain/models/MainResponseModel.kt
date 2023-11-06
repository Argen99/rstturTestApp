package com.example.domain.models

data class MainResponseModel(
    val success: Boolean,
    val error: ErrorModel?,
    val time: String,
    val data: MainDataModel
)
