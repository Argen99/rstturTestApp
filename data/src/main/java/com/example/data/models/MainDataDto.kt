package com.example.data.models

import com.example.data.utils.DataMapper
import com.example.domain.models.MainDataModel

data class MainDataDto(
    val buttons: List<ButtonDto>,
    val content: List<ContentDto>
) : DataMapper<MainDataModel> {
    override fun toDomain() = MainDataModel(
        buttons = buttons.map { it.toDomain() },
        content = content.map { it.toDomain() }
    )
}
