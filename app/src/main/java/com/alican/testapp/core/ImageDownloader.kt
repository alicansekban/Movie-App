package com.alican.testapp.core

import android.widget.ImageView
import com.squareup.picasso.Picasso


/**
 * Abstract class for image downloading library
 */
object ImageDownloader {
    fun download(url: String, view: ImageView) {
        Picasso.get()
            .load(url)
            .fit()
            .centerCrop()
            .into(view)
    }
}