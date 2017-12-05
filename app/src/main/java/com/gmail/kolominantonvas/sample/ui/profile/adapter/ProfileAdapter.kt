package com.gmail.kolominantonvas.sample.ui.profile.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.gmail.kolominantonvas.sample.entity.constant.AdapterConstants
import com.gmail.kolominantonvas.sample.entity.pojo.ProfileItemData
import com.gmail.kolominantonvas.sample.extension.get
import com.gmail.kolominantonvas.sample.ui.base.ViewType
import com.gmail.kolominantonvas.sample.ui.base.ViewTypeDelegateAdapter
import io.reactivex.subjects.PublishSubject

/**
 * Created by Anton Kolomin on 28-Nov-17.
 */
class ProfileAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: MutableSet<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    var clickListener: PublishSubject<String> = PublishSubject.create<String>()

    init {
        delegateAdapters.put(AdapterConstants.Profile.ITEM, ProfileItemDelegateAdapter(clickListener))
        items = mutableSetOf()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
            delegateAdapters.get(getItemViewType(position))
                    .onBindViewHolder(holder, items.get(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            delegateAdapters.get(viewType).onCreateViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int) = items.get(position)!!.getViewType()

    fun setData(data: MutableSet<ProfileItemData>) {
        val initPosition = items.size
        items.addAll(data)
        notifyItemRangeChanged(initPosition, items.size)
    }
}