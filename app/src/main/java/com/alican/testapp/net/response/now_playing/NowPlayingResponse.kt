package com.alican.testapp.net.response.now_playing

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NowPlayingResponse(

    @Json(name = "dates")
    val dates: Dates? = null,

    @Json(name = "page")
    val page: Int? = null,

    @Json(name = "total_pages")
    val totalPages: Int? = null,

    @Json(name = "results")
    val results: List<ResultsItem>? = null,

    @Json(name = "total_results")
    val totalResults: Int? = null
) : Parcelable