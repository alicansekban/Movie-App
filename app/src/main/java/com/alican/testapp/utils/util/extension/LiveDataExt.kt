package com.alican.testapp.utils.util.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer


inline fun <T : Any> LiveData<T>.observeWith(
    lifecycleOwner: LifecycleOwner,
    crossinline onChanged: (T) -> Unit
) {
    observe(
        lifecycleOwner,
        Observer {
            it ?: return@Observer
            onChanged.invoke(it)
        }
    )
}

fun <T> MutableLiveData<T>.forceRefresh() {
    this.value = this.value
}
