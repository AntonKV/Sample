package com.gmail.kolominantonvas.sample.model.repository.profile

import com.gmail.kolominantonvas.sample.model.data.server.profile.ProfileService
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 28-Nov-17.
 */
class ProfileRepository @Inject constructor(
        private val service: ProfileService
) {
    fun getProfile(userId: Int) = service.getProfile(userId)
}