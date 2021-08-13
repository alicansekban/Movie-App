package com.alican.testapp.ui.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alican.testapp.core.BaseViewModel
import com.alican.testapp.net.Api
import com.alican.testapp.net.response.now_playing.NowPlayingResponse
import com.alican.testapp.net.response.up_coming.UpComingResponse
import com.alican.testapp.utils.util.ResultWrapper
import com.alican.testapp.utils.util.safeApiCall
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val api: Api
) : BaseViewModel() {

    val upComingResponse = MutableLiveData<UpComingResponse>()
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