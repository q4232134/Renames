package jiaozhu.com.common
import androidx.compose.ui.graphics.ImageBitmap

expect fun getPlatformName(): String

expect fun getImage(res:String) : ImageBitmap