package com.alican.testapp.ui.main

import com.alican.testapp.core.BaseViewModel
import com.alican.testapp.db.AppDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val db: AppDatabase
) : BaseViewModel() {

}