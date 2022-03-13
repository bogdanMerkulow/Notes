package com.example.notes.common.usecase

class NotesUseCaseImpl(
    private val routerUseCase: RouterUseCase
): NotesUseCase {

    override fun createNote() {
        routerUseCase.createNote()
    }

    override fun editNote(id: Long) {

    }

    override fun removeNote(id: Long) {

    }
}