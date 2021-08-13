package com.alican.testapp.net.response.movie_detail

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenresItem(

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "id")
    val id: Int? = null
) : Parcelable