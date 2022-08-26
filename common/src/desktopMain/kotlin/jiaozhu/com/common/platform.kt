package jiaozhu.com.common

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource

actual fun getPlatformName(): String {
    return "Desktop"
}

actual fun getImage(res: String): ImageBitmap? = useResource(res, ::loadImageBitmap)