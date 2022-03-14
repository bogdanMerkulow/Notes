package com.example.notes.common.router

import com.example.R
import com.example.common.navigation.NavCommand
import com.example.notes.common.usecase.RouterUseCase

class RouterUseCaseImpl: RouterUseCase {
    override fun createNoteNavCommand() =
        NavCommand(R.id.action_noteListFragment_to_noteCreateFragment)
}