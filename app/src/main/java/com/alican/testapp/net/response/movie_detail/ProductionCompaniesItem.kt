package com.alican.testapp.net.response.movie_detail

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductionCompaniesItem(

    @Json(name = "logo_path")
    val logoPath: String? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "origin_country")
    val originCountry: String? = null
) : Parcelable