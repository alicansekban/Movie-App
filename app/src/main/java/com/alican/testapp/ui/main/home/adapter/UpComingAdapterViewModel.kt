package com.alican.testapp.ui.main.home.adapter

import androidx.databinding.ObservableField
import com.alican.testapp.core.BaseViewModel
import com.alican.testapp.net.response.up_coming.ResultsItem
import javax.inject.Inject

class UpComingAdapterViewModel @Inject constructor() : BaseViewModel() {

    val item = ObservableField<ResultsItem>()
}