package com.example.notes.list

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.common.flow.launchWhenViewCreated
import com.example.common.fragment.BindingFragment
import com.example.common.viewmodel.getViewModelFactory
import com.example.databinding.FragmentNoteListBinding
import com.example.notes.common.models.Note
import com.example.notes.list.viewholders.NoteItem
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil

class NoteListFragment :
    BindingFragment<FragmentNoteListBinding>(FragmentNoteListBinding::inflate) {

    private val viewModel: NotesViewModel by viewModels { getViewModelFactory() }

    private val notesAdapter = ItemAdapter<NoteItem>()
    private val recyclerViewAdapter = FastAdapter.with(notesAdapter)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadNotes()

        observeData()
        setupData()
    }

    private fun setupData() {
        with(binding) {
            notesRecycler.adapter = recyclerViewAdapter
            notesRecycler.itemAnimator = null
            notesRecycler.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    LinearLayout.VERTICAL
                )
            )

            createNoteButton.setOnClickListener {
                viewModel.onCreateNote()
            }
        }
    }

    private fun observeData() {
        launchWhenViewCreated {
            with(viewModel) {
                notes.observe(::onNotesLoaded)
            }
        }
    }

    private fun onNotesLoaded(notes: List<Note>) {
        FastAdapterDiffUtil[notesAdapter] = notes.map { note ->
            NoteItem(
                note,
                viewModel::onEditNote,
                viewModel::onRemoveNote
            )
        }
    }
}