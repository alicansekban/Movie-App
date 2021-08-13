package com.alican.testapp.net.response.now_playing

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dates(

    @Json(name = "maximum")
    val maximum: String? = null,

    @Json(name = "minimum")
    val minimum: String? = null
) : Parcelable