package com.telegramflow.example.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
actual fun LocalImage(
    path: String?,
    contentDescription: String?,
    modifier: Modifier,
    contentScale: ContentScale
) {
    AsyncImage(
        model = path,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
    )
}
