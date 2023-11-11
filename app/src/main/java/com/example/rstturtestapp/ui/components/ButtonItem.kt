package com.example.rstturtestapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.models.main_response.ButtonModel
import com.example.rstturtestapp.R
import com.example.rstturtestapp.ui.theme.White
import com.example.rstturtestapp.ui.theme.g11
import com.example.rstturtestapp.ui.theme.g12
import com.example.rstturtestapp.ui.theme.g13

@Composable
fun ButtonItem(
    button: ButtonModel,
    modifier: Modifier = Modifier,
    onClick: (url: String) -> Unit = { }
) {
    val colors = mapOf(
        "g-13" to g13,
        "g-12" to g12,
        "g-11" to g11,
    )

    val icons = mapOf(
        "g-13" to painterResource(id = R.drawable.ic_btn_sunny),
        "g-12" to painterResource(id = R.drawable.ic_btn_help),
        "g-11" to painterResource(id = R.drawable.ic_btn_map)
    )

    Row(
        modifier = modifier
            .clip(ShapeDefaults.Small)
            .background(colors[button.color] ?: g13)
            .height(40.dp)
            .defaultMinSize(minWidth = 84.dp)
            .clickable {
                onClick(button.url)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(horizontal = 8.dp),
            painter = icons[button.color] ?: painterResource(id = R.drawable.ic_btn_sunny),
            contentDescription = null,
            tint = White
        )
        Text(
            modifier = Modifier.padding(end = 8.dp),
            text = button.title,
            style = TextStyle(
                fontSize = 14.sp,
                color = White
            ),
            maxLines = 1
        )
    }
}