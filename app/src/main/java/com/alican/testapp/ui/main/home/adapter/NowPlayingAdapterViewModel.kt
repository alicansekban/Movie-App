package com.alican.testapp.ui.main.home.adapter

import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import com.alican.testapp.core.BaseViewModel
import com.alican.testapp.net.response.now_playing.ResultsItem

class NowPlayingAdapterViewModel @ViewModelInject constructor() : BaseViewModel() {

    val item = ObservableField<ResultsItem>()
}