package com.alican.testapp.ui.main.detail

import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.alican.testapp.core.BaseViewModel
import com.alican.testapp.net.Api
import com.alican.testapp.net.response.movie_detail.MovieDetailResponse
import com.alican.testapp.utils.util.ResultWrapper
import com.alican.testapp.utils.util.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailViewModel @ViewModelInject constructor(
    private val api: Api
) : BaseViewModel() {

    val movieDetailResponse = ObservableField<MovieDetailResponse>()

    fun getUpComingMovies(id: String) {
        progressLiveData.postValue(true)
        viewModelScope.launch {
            when (val response = safeApiCall(Dispatchers.IO) { api.getMovieDetail(id) }) {
                is ResultWrapper.Success -> {

                    movieDetailResponse.set(response.value)
                    progressLiveData.postValue(false)
                }
                is ResultWrapper.GenericError -> {
                    showGenericError(response)
                }
                else -> progressLiveData.postValue(false)
            }
        }
    }
}