package com.lotaspeak.speak.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageLoader {

    companion object {
        fun load(context: Context, url: String?, imageView: ImageView) {
            Glide.with(context).load(url)
                .into(imageView)
        }
    }
}