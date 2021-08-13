package com.alican.testapp.utils.util

import android.content.Context
import android.content.Intent
import android.net.Uri

object AppUtils {

    fun getOpenFacebookIntent(context: Context, url: String) {
        return try {
            context.packageManager.getPackageInfo("com.facebook.katana", 0)
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("fb://facewebmodal/f?href=$url")
                )
            )
        } catch (e: Exception) {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }

    fun getOpenTwitterIntent(context: Context, url: String) {
        var intent: Intent? = null
        try {
            // get the Twitter app if possible
            context.packageManager.getPackageInfo("com.twitter.android", 0)
            intent = Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=USERID"))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        } catch (e: java.lang.Exception) {
            // no Twitter app, revert to browser
            intent =
                Intent(Intent.ACTION_VIEW, Uri.parse(url))
        }
        context.startActivity(intent)
    }
}