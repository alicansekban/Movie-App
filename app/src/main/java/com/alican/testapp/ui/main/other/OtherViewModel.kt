package com.alican.testapp.ui.main.other

import com.alican.testapp.core.BaseViewModel
import com.alican.testapp.net.Api
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OtherViewModel @Inject constructor(
    private val api: Api
) : BaseViewModel() {
}