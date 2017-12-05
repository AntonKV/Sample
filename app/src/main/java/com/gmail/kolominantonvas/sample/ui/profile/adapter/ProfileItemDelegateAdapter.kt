package com.gmail.kolominantonvas.sample.ui.profile.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.gmail.kolominantonvas.sample.R
import com.gmail.kolominantonvas.sample.entity.pojo.ProfileItemData
import com.gmail.kolominantonvas.sample.extension.inflate
import com.gmail.kolominantonvas.sample.ui.base.ViewType
import com.gmail.kolominantonvas.sample.ui.base.ViewTypeDelegateAdapter
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_profile.view.*

/**
 * Created by Anton Kolomin on 28-Nov-17.
 */
class ProfileItemDelegateAdapter(val clickListener: PublishSubject<String>) : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = ProfileItemViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType?) {
        holder as ProfileItemViewHolder
        holder.bind(item as ProfileItemData)
    }

    inner class ProfileItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.item_profile)) {
        fun bind(data: ProfileItemData) {
            itemView.item_title.text = data.title
            itemView.subtitle.text = data.value

            super.itemView.setOnClickListener { clickListener.onNext(data.value) }
        }
    }
}