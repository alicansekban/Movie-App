package com.alican.testapp

import android.app.Application
import android.content.Context
import com.akexorcist.localizationactivity.ui.LocalizationApplication
import dagger.hilt.android.HiltAndroidApp
import java.util.*

@HiltAndroidApp
class App : LocalizationApplication() {
    override fun getDefaultLanguage(base: Context): Locale {
        return Locale.getDefault()
    }
}