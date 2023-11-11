package com.example.rstturtestapp.ui.components

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.domain.models.content_response.ContentModel

@Composable
fun ContentItem(
    item: ContentModel,
    onItemClick: (id: Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(item.id)
            }
    ) {
        Picasso(
            modifier = Modifier
                .fillMaxWidth()
                .clip(ShapeDefaults.Small),
            imageUri = Uri.parse(item.image.sm)
        )
        item.title?.let {
            Text(
                text = it,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        item.subtitle?.let {
            Text(
                text = it,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                maxLines = if (item.title == null) 4 else 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}