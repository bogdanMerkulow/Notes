package com.example.notes.list.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.R
import com.example.databinding.ListItemNoteBinding
import com.example.notes.common.models.Note
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class NoteItem(
    private val note: Note,
    private val onEditClick: (Long) -> Unit = {  },
    private val onRemoveClick: (Long) -> Unit = {  }
) : AbstractBindingItem<ListItemNoteBinding>() {

    override val type: Int = R.layout.list_item_note
    override var identifier: Long = note.hashCode().toLong()

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ListItemNoteBinding =
        ListItemNoteBinding.inflate(inflater, parent, false)

    override fun bindView(binding: ListItemNoteBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        with(binding) {
            title.text = note.title
            content.text = note.content

            edit.setOnClickListener { onEditClick(note.id) }
            remove.setOnClickListener { onRemoveClick(note.id) }
        }
    }
}