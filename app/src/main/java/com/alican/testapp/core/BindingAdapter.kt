package com.alican.testapp.core

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("visibility")
    fun setVisibility(view: View, isVisible: Boolean) {
        view.visibility = View.GONE
        if (isVisible) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    @JvmStatic
    @BindingAdapter("visibilityNot")
    fun setVisibilityNot(view: View, isVisible: Boolean) {
        view.visibility = View.GONE
        if (isVisible.not()) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    @JvmStatic
    @BindingAdapter("enabled")
    fun setEnabled(view: View, isEnabled: Boolean) {
        view.isEnabled = isEnabled
    }

    @JvmStatic
    @BindingAdapter("urlImage")
    fun ImageView.bindUrlImage(imageUrl: String?) {
        if (imageUrl != null) {
            ImageDownloader.download(imageUrl, this)
        } else {
            this.setImageBitmap(null)
        }
    }
}