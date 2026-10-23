package com.example.ap2futdex

import android.content.Context
import coil.ImageLoader
import coil.decode.SvgDecoder

object FutDexImageLoader {
    fun criar(context: Context): ImageLoader {
        return ImageLoader.Builder(context)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()
    }
}
