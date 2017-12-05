package com.gmail.kolominantonvas.sample.extension

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

fun Context.toast(@StringRes message: Int) = toast(this.getString(message))

fun Context.toast(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Fragment.getBundleFragment(vararg data: Any?): Fragment {
    try {
        this.arguments = ExtensionUtils.getBundle(*data)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return this
}

fun <T> MutableSet<T>.get(n: Int): T? {
    return this
            .filterIndexed { index, _ -> index == n }
            .firstOrNull()
}