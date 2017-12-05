package com.gmail.kolominantonvas.sample.entity.pojo

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
data class AuthData(val id: Int, val name: String) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<AuthData> = object : Parcelable.Creator<AuthData> {
            override fun createFromParcel(source: Parcel): AuthData = AuthData(source)
            override fun newArray(size: Int): Array<AuthData?> = arrayOfNulls(size)
        }
    }
}