package com.alican.testapp.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.alican.testapp.core.BaseViewModel
import com.alican.testapp.db.AppDatabase

class MainViewModel @ViewModelInject constructor(
    private val db: AppDatabase
) : BaseViewModel() {
    var needRestartAppForLocale: MutableLiveData<Boolean> = MutableLiveData()


}