package com.alican.testapp.net

import com.alican.testapp.net.response.movie_detail.MovieDetailResponse
import com.alican.testapp.net.response.now_playing.NowPlayingResponse
import com.alican.testapp.net.response.up_coming.UpComingResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("now_playing")
    suspend fun getNowPlayingMovies(): NowPlayingResponse

    @GET("upcoming")
    suspend fun getUpComingMovies(): UpComingResponse

    @GET("{id}")
    suspend fun getMovieDetail(@Path("id") id: String): MovieDetailResponse
}