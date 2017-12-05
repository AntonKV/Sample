package com.gmail.kolominantonvas.sample.model.data.auth

/**
 * Created by Anton Kolomin on 05-Dec-17.
 */
interface AuthHolder {
    companion object {
        const val AUTH_DATA = "auth_data"
        const val USER_ID = "user_id"
        const val USER_NAME = "user_name"
    }

    var id: Int
    var name:String?
}