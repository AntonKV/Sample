package com.gmail.kolominantonvas.sample.entity.annotation

/**
 * Created by Anton Kolomin on 27-Nov-17.
 */
@kotlin.annotation.Retention
annotation class Toolbar(val back: Boolean = true, val title: Int = -1, val subtitle: Int = -1)