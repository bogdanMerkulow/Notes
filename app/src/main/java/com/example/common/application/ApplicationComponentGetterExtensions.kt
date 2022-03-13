package com.example.common.application

import android.app.Activity
import java.lang.IllegalArgumentException

fun Activity.getApplicationComponent(): ApplicationComponent {
    val application = this.application
    if (application !is NotesApplication) {
        throw IllegalArgumentException("Приложение должно быть типа NotesApplication.")
    }

    return application.applicationComponent
}