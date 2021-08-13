package com.alican.testapp.ui.main.other

import androidx.hilt.lifecycle.ViewModelInject
import com.alican.testapp.core.BaseViewModel
import com.alican.testapp.net.Api

class OtherViewModel @ViewModelInject constructor(
    private val api: Api
) : BaseViewModel() {
}