package com.gmail.kolominantonvas.sample.model.data.storage

import android.content.Context
import com.gmail.kolominantonvas.sample.model.data.auth.AuthHolder
import com.gmail.kolominantonvas.sample.model.data.auth.AuthHolder.Companion.AUTH_DATA
import com.gmail.kolominantonvas.sample.model.data.auth.AuthHolder.Companion.USER_ID
import com.gmail.kolominantonvas.sample.model.data.auth.AuthHolder.Companion.USER_NAME
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 05-Dec-17.
 */
class Prefs @Inject constructor(
        private val context: Context
) : AuthHolder {

    private fun getSharedPreferences(prefsName: String)
            = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)

    override var id: Int
        get() = getSharedPreferences(AuthHolder.AUTH_DATA).getInt(USER_ID, 0)
        set(value) {
            getSharedPreferences(AUTH_DATA).edit().putInt(USER_ID, value).apply()
        }

    override var name: String?
        get() = getSharedPreferences(AuthHolder.AUTH_DATA).getString(USER_NAME, null)
        set(value) {
            getSharedPreferences(AUTH_DATA).edit().putString(USER_NAME, value).apply()
        }
}