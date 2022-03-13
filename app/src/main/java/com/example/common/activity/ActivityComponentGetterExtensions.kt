package com.example.common.activity

import android.app.Activity
import androidx.fragment.app.Fragment

fun Activity.getActivityComponent(): ActivityComponent {
    if (this !is ActivityComponentHolder)
        throw IllegalArgumentException("Activity должно реализовывать интерфейс ActivityComponentHolder")

    return this.getActivityComponent()
}

fun Fragment.getActivityComponent(): ActivityComponent = requireActivity().getActivityComponent()