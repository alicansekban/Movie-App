package com.alican.testapp.ui.main.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alican.testapp.core.BaseViewModel
import com.alican.testapp.net.Api
import com.alican.testapp.net.response.now_playing.NowPlayingResponse
import com.alican.testapp.net.response.up_coming.UpComingResponse
import com.alican.testapp.utils.util.ResultWrapper
import com.alican.testapp.utils.util.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val api: Api
) : BaseViewModel() {

    val upComingResponse = MutableLiveData<List<UpComingResponse>>()
    val nowPlayingResponse = MutableLiveData<NowPlayingResponse>()

    init {
        getUpComingMovies()
        getNowPlayingMovies()
    }

    fun getUpComingMovies() {
        progressLiveData.postValue(true)
        viewModelScope.launch {
            when (val response = safeApiCall(Dispatchers.IO) { api.getUpComingMovies() }) {
                is ResultWrapper.Success -> {

                    upComingResponse.postValue(response.value)
                    progressLiveData.postValue(false)
                }
                is ResultWrapper.GenericError -> {
                    showGenericError(response)
                }
                else -> progressLiveData.postValue(false)
            }
        }
    }

    fun getNowPlayingMovies() {
        progressLiveData.postValue(true)
        viewModelScope.launch {
            when (val response = safeApiCall(Dispatchers.IO) { api.getNowPlayingMovies() }) {
                is ResultWrapper.Success -> {

                    nowPlayingResponse.postValue(response.value)
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