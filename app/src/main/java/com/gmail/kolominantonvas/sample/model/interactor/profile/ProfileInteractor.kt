package com.gmail.kolominantonvas.sample.model.interactor.profile

import com.gmail.kolominantonvas.sample.entity.pojo.AuthData
import com.gmail.kolominantonvas.sample.entity.pojo.ProfileItemData
import com.gmail.kolominantonvas.sample.model.repository.profile.ProfileRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Anton Kolomin on 28-Nov-17.
 */
class ProfileInteractor @Inject constructor(
        private val profileRepository: ProfileRepository
) {
    fun getProfile(authData: AuthData): Single<MutableSet<ProfileItemData>> =
            profileRepository.getProfile(authData.id).flatMap { data ->
                Single.create<MutableSet<ProfileItemData>> {
                    val items: MutableSet<ProfileItemData> = mutableSetOf()
                    items.add(ProfileItemData("id", data.id.toString()))
                    items.add(ProfileItemData("name", data.name))
                    items.add(ProfileItemData("surname", data.surname))
                    items.add(ProfileItemData("phone", data.phone))
                    items.add(ProfileItemData("address", data.address))
                    it.onSuccess(items)
                }
            }
}