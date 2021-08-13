package com.alican.testapp.net.response.movie_detail

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductionCountriesItem(

    @Json(name = "iso_3166_1")
    val iso31661: String? = null,

    @Json(name = "name")
    val name: String? = null
) : Parcelable