package com.alican.workapp.utils.util.extension

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Matrix
import android.net.Uri
import android.text.TextUtils
import androidx.exifinterface.media.ExifInterface
import java.text.SimpleDateFormat
import java.util.*


fun String.isEmailValid(): Boolean {
    return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}


fun String?.formatDateToTime(): String? {
    if (this.isNullOrEmpty())
        return ""
    this.let {
        var currentFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val newDate = currentFormat.parse(this)

        currentFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        return currentFormat.format(newDate)
    }
}

fun String?.formatDateToShow(): String? {
    if (this.isNullOrEmpty())
        return ""
    this.let {
        var currentFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val newDate = currentFormat.parse(this)

        currentFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        return currentFormat.format(newDate)
    }
}

fun String?.formatDateToSend(): String? {
    if (this.isNullOrEmpty())
        return ""
    this.let {
        var currentFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val newDate = currentFormat.parse(this)

        currentFormat = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())
        return currentFormat.format(newDate)
    }
}

fun String?.stringToDate(): Date {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    return formatter.parse(this) as Date
}

fun Int.getDaysAgo(): Date {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, -this)
    return calendar.time
}

//fun Activity?.restartApp() {
//    val intent = Intent(this, SplashActivity::class.java)
//    this?.let {
//        startActivity(intent)
//        this.finishAffinity()
//        overridePendingTransition(0, 0)
//    }
//}

fun Activity?.closeApp() {
    this?.let {
        this.finishAffinity()
    }
}

fun Activity?.openWebPage(url: String) {
    this?.let {
        val webPage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webPage)
        if (intent.resolveActivity(it.packageManager) != null) {
            startActivity(intent)
        }
    }
}

fun Bitmap.fixRotation(uri: Uri): Bitmap? {

    val ei = uri.path?.let { ExifInterface(it) }

    val orientation: Int? = ei?.getAttributeInt(
        ExifInterface.TAG_ORIENTATION,
        ExifInterface.ORIENTATION_UNDEFINED
    )

    return when (orientation) {
        ExifInterface.ORIENTATION_ROTATE_90 -> rotateImage(90f)
        ExifInterface.ORIENTATION_ROTATE_180 -> rotateImage(180f)
        ExifInterface.ORIENTATION_ROTATE_270 -> rotateImage(270f)
        ExifInterface.ORIENTATION_NORMAL -> this
        else -> this
    }
}

fun Bitmap.rotateImage(angle: Float): Bitmap? {
    val matrix = Matrix()
    matrix.postRotate(angle)
    return Bitmap.createBitmap(
        this, 0, 0, width, height,
        matrix, true
    )
}

fun String.insert(index: Int, string: String): String {
    return this.substring(0, index) + string + this.substring(index, this.length)
}