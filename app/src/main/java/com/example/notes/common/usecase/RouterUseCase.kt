package com.example.notes.common.usecase

import com.example.common.navigation.NavCommand

interface RouterUseCase {

    fun createNoteNavCommand(): NavCommand
}