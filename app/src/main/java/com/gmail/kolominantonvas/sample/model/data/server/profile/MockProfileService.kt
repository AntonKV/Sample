package com.gmail.kolominantonvas.sample.model.data.server.profile

import com.gmail.kolominantonvas.sample.entity.pojo.ProfileData
import io.reactivex.Single

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
class MockProfileService : ProfileService {
    override fun getProfile(userId: Int): Single<ProfileData> = Single.create({
        when (userId) {
            1 -> it.onSuccess(ProfileData(2, "Anton", "Kolomin",
                    "+7(919) 779-61-25", "http://www.kolomin.ru/"))
            else -> it.onError(Throwable("User not found"))
        }
    })
}