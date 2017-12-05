package com.gmail.kolominantonvas.sample.ui.profile

import com.gmail.kolominantonvas.sample.entity.pojo.ProfileItemData
import com.gmail.kolominantonvas.sample.ui.base.BaseView

/**
 * Created by Anton Kolomin on 28-Nov-17.
 */
interface ProfileView : BaseView {
    fun showData(data: MutableSet<ProfileItemData>)
}