package com.example.notes.common.router

import com.example.R
import com.example.common.navigation.NavControllerFactory
import com.example.notes.common.usecase.RouterUseCase

class RouterUseCaseImpl(private val getNavController: NavControllerFactory): RouterUseCase {
    override fun createNote() {
        getNavController().navigate(R.id.action_noteListFragment_to_noteCreateFragment)
    }
}