package com.example.common.navigation

import androidx.navigation.NavController

fun interface NavControllerFactory {
    operator fun invoke(): NavController
}