package com.example.domain.models.content_response

import com.example.domain.models.main_response.ErrorModel

data class ContentResponseModel(
    val success: Boolean,
    val error: ErrorModel?,
    val time: String,
    val data: List<ContentModel>
)
