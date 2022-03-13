package com.example.common.viewmodel

import androidx.fragment.app.Fragment
import com.example.common.activity.getActivityComponent

fun Fragment.getViewModelFactory() = getActivityComponent().getViewModelFactory()