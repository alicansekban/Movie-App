package com.alican.testapp.ui.main.language

import android.content.SharedPreferences
import com.alican.testapp.core.BaseViewModel
import com.alican.testapp.net.Api
import javax.inject.Inject

class LanguageViewModel@Inject constructor(val api:Api , val pref: SharedPreferences):BaseViewModel() {
}