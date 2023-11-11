package com.example.rstturtestapp.ui.components

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun Picasso(
    modifier: Modifier = Modifier,
    imageUri: Uri?,
) {
    val image = remember { mutableStateOf<Bitmap?>(null) }

    LaunchedEffect(imageUri) {
        image.value = withContext(Dispatchers.IO) {
            Picasso.get()
                .load(imageUri)
                .get()
        }
    }

    image.value?.let { bitmap ->
        Image(
            modifier = modifier,
            bitmap = bitmap.asImageBitmap(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}