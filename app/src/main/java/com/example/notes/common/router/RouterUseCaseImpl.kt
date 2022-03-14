package com.example.notes.common.router

import com.example.R
import com.example.common.navigation.NavControllerFactory
import com.example.notes.common.usecase.RouterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RouterUseCaseImpl(private val getNavController: NavControllerFactory): RouterUseCase {
    override suspend fun createNote() {
        withContext(Dispatchers.Main) {
            getNavController().navigate(R.id.action_noteListFragment_to_noteCreateFragment)

        }
    }

    override suspend fun listNotes() {
        withContext(Dispatchers.Main) {
            getNavController().navigateUp()
        }
    }
}