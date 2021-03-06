package com.example.notes.create

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.common.flow.launchWhenViewCreated
import com.example.common.fragment.BindingFragment
import com.example.common.viewmodel.getViewModelFactory
import com.example.databinding.FragmentNoteCreateBinding

class NoteCreateFragment : BindingFragment<FragmentNoteCreateBinding>(
    FragmentNoteCreateBinding::inflate
) {

    private val viewModel: NoteCreateViewModel by viewModels { getViewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            save.setOnClickListener(::onSaveClick)
            toolbar.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }

        launchWhenViewCreated {
            with(viewModel) {
                noteCreated.observe {
                    findNavController().navigateUp()
                }
            }
        }
    }

    private fun onSaveClick(v: View) {
        val title = binding.title.text.toString()
        val content = binding.content.text.toString()

        viewModel.createNote(title, content)
    }
}