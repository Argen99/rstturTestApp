package com.example.rstturtestapp.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.example.rstturtestapp.ui.components.ButtonItem
import com.example.rstturtestapp.ui.components.ContentItem
import com.example.rstturtestapp.ui.components.ShowAllButton
import com.example.rstturtestapp.ui.components.TitleText
import com.example.rstturtestapp.utils.showToast
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = getViewModel(),
    onItemClick: (id: Int) -> Unit
) {
    val context = LocalContext.current
    val mainData by viewModel.mainState.observeAsState()
    val content by viewModel.contentState.observeAsState()
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(mainData?.buttons ?: emptyList()) { button ->
                ButtonItem(button = button) { url ->
                    try {
                        uriHandler.openUri(url)
                    } catch (e: Exception) {
                        e.localizedMessage?.let { context.showToast(it) }
                    }
                }
            }
        }

        mainData?.content?.forEach { model ->
            TitleText(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp),
                text = model.title
            )

            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 2000.dp),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(
                    horizontal = 16.dp, vertical = 20.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(content?.get(model.title)?.take(6) ?: emptyList()) { item ->
                    ContentItem(item = item) { id ->
                        if (model.template.obj == "blog") {
                            onItemClick(id)
                        } else {
                            context.showToast("click on the blog")
                        }
                    }
                }
            }
            ShowAllButton(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 20.dp),
                count = content?.get(model.title)?.size
            )
            Divider(color = MaterialTheme.colorScheme.outline, thickness = 1.dp)
        }
    }
}