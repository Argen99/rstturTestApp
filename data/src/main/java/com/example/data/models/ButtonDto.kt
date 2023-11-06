package com.example.data.models

import com.example.data.utils.DataMapper
import com.example.domain.models.ButtonModel

data class ButtonDto(
    val icon: String,
    val color: String,
    val title: String,
    val type: String,
    val url: String
) : DataMapper<ButtonModel> {
    override fun toDomain() = ButtonModel(
        icon = icon,
        color = color,
        title = title,
        type = type,
        url = url,
    )
}
