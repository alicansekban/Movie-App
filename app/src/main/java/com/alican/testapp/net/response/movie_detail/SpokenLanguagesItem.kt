package com.alican.testapp.net.response.movie_detail

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SpokenLanguagesItem(

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "iso_639_1")
    val iso6391: String? = null,

    @Json(name = "english_name")
    val englishName: String? = null
) : Parcelable