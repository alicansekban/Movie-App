package com.alican.testapp.utils.util

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.alican.testapp.core.Constants
import com.alican.testapp.ui.main.MainActivity
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(val pref: SharedPreferences, val context: Context) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {

        val token = Constants.Pref.TOKEN
        val request = chain.request()


        var modifiedRequest = request

        modifiedRequest = if (token?.isNotEmpty() == true) {
            request.newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
        } else {
            request.newBuilder()
                .build()
        }

        val response = chain.proceed(modifiedRequest)
        if (response.body?.contentType() != null) {
            if (response.code == 401) {
                pref.edit().putString(Constants.Pref.TOKEN, "").apply()
                val intent = Intent(context, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.applicationContext.startActivity(intent)
            }

        }
        return response
    }
}