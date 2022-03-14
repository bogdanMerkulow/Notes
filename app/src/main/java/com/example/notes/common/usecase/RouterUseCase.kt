package com.example.notes.common.usecase

interface RouterUseCase {

    suspend fun createNote()

    suspend fun listNotes()
}