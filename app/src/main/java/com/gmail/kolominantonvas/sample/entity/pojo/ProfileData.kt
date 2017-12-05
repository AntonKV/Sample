package com.gmail.kolominantonvas.sample.entity.pojo

import com.gmail.kolominantonvas.sample.entity.constant.AdapterConstants
import com.gmail.kolominantonvas.sample.ui.base.ViewType

/**
 * Created by Anton Kolomin on 28-Nov-17.
 */
data class ProfileData(
        val id: Int,
        val name: String,
        val surname: String,
        val phone: String,
        val address: String
)

data class ProfileItemData(
        val title: String,
        val value: String
): ViewType { override fun getViewType() = AdapterConstants.Profile.ITEM }