package com.telegramflow.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import kotlinx.cinterop.*
import org.jetbrains.skia.Image as SkiaImage
import platform.Foundation.NSData
import platform.Foundation.dataWithContentsOfFile

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun LocalImage(
    path: String?,
    contentDescription: String?,
    modifier: Modifier,
    contentScale: ContentScale
) {
    val imageBitmap = remember(path) {
        if (path == null) return@remember null
        try {
            val data = NSData.dataWithContentsOfFile(path) ?: return@remember null
            val bytes = ByteArray(data.length.toInt())
            bytes.usePinned { pinned ->
                platform.posix.memcpy(pinned.addressOf(0), data.bytes, data.length)
            }
            val skiaImg = SkiaImage.makeFromEncoded(bytes)
            skiaImg.toComposeImageBitmap()
        } catch (e: Exception) {
            println("Failed to load local image at path '$path': ${e.message}")
            null
        }
    }

    if (imageBitmap != null) {
        Image(
            bitmap = imageBitmap,
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = modifier
        )
    } else {
        Box(
            modifier = modifier.background(Color.LightGray.copy(alpha = 0.5f)),
            contentAlignment = Alignment.Center
        ) {}
    }
}
