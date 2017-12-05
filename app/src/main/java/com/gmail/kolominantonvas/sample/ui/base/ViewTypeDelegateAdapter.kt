package com.gmail.kolominantonvas.sample.ui.base

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType?)
}