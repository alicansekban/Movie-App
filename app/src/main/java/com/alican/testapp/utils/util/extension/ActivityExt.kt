package com.alican.workapp.utils.util.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

inline fun <reified T : Activity> Context.intentFor(vararg params: Pair<String, Any?>): Intent {
    val arguments = bundleOf(*params)
    return Intent(this, T::class.java).apply { putExtras(arguments) }
}

inline fun <reified T : Activity> Context.startActivity(vararg params: Pair<String, Any?>) {
    val intent = intentFor<T>(*params)
    startActivity(intent)
}

inline fun <reified T : Activity> Activity.startActivityWithResult(
    requestCode: Int,
    vararg params: Pair<String, Any?>
) {
    val intent = intentFor<T>(*params)
    startActivityForResult(intent, requestCode)
}

inline fun <reified T : Activity> Fragment.startActivityWithResult(
    requestCode: Int,
    vararg params: Pair<String, Any?>
) {
    val intent = requireContext().intentFor<T>(*params)
    startActivityForResult(intent, requestCode)
}

inline fun <reified T : Activity> Context.startActivityClearStack(vararg params: Pair<String, Any?>) {
    val intent = intentFor<T>(*params).apply {
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
    }
    startActivity(intent)
}

inline fun <reified T : Fragment> newInstanceOf(vararg params: Pair<String, Any>): Fragment {
    return T::class.java.newInstance().apply { arguments = bundleOf(*params) }
}

fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, duration).show()

inline fun Activity.alertDialog(body: AlertDialog.Builder.() -> AlertDialog.Builder): AlertDialog {
    return AlertDialog.Builder(this)
        .body()
        .show()
}

