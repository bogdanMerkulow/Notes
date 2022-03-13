package com.example.common.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.R
import com.example.common.application.getApplicationComponent

class MainActivity : AppCompatActivity(), ActivityComponentHolder {

    private val component by lazy {
        getApplicationComponent()
            .getActivityComponentBuilder()
            .activityModule(ActivityModule(this))
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getActivityComponent(): ActivityComponent = component
}