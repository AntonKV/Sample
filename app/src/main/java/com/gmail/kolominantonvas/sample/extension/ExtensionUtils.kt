package com.gmail.kolominantonvas.sample.extension

import android.os.Bundle
import android.os.Parcelable

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
object ExtensionUtils {
    fun getBundle(vararg args: Any?): Bundle {
        val bundle = Bundle()
        args.indices
                .filter { it % 2 == 0 }
                .forEach { put(bundle, args[it].toString(), args[it + 1]) }
        return bundle
    }

    private fun put(bundle: Bundle, key: String, value: Any?) {
        when (value) {
            is Int -> bundle.putInt(key, value)
            is String -> bundle.putString(key, value)
            is Boolean -> bundle.putBoolean(key, value)
            is Parcelable -> bundle.putParcelable(key, value)
        }
    }
}