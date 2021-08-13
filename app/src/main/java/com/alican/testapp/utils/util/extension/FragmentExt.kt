package com.alican.testapp.utils.util.extension

import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.alican.testapp.ui.main.ProgressDialogFragment
import com.alican.workapp.utils.util.extension.alertDialog
import com.alican.workapp.utils.util.extension.toast


fun androidx.fragment.app.Fragment.toast(
    message: CharSequence,
    duration: Int = Toast.LENGTH_SHORT
) = activity?.toast(message, duration)

inline fun androidx.fragment.app.Fragment.alertDialog(body: AlertDialog.Builder.() -> AlertDialog.Builder) =
    activity?.alertDialog(body)

fun Fragment.showProgressDialog() {
    val dialogProgressFragment = ProgressDialogFragment()
    val prev: DialogFragment? =
        requireActivity().supportFragmentManager.findFragmentByTag("dialogProgress") as DialogFragment?
    if (prev == null)
        dialogProgressFragment.show(requireActivity().supportFragmentManager, "dialogProgress")


}

fun Fragment.dismissProgressDialog() {
    val prev: DialogFragment? =
        requireActivity().supportFragmentManager.findFragmentByTag("dialogProgress") as DialogFragment?
    prev?.dismiss()
}

