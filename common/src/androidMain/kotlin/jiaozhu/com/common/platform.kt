package jiaozhu.com.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource

actual fun getPlatformName(): String {
    return "Android"
}

@Composable
actual fun getImage(res: String): ImageBitmap? {
    return ImageBitmap.imageResource(id = R.drawable.item)
}