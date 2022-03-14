package com.example.common.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.R
import com.example.common.application.getApplicationComponent
import com.example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ActivityComponentHolder {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val component by lazy {
        getApplicationComponent()
            .getActivityComponentBuilder()
            .activityModule(ActivityModule(this))
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun getActivityComponent(): ActivityComponent = component
}