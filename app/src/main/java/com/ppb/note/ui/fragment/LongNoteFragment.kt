package com.ppb.note.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ppb.note.R
import com.ppb.note.model.DefaultNote
import com.ppb.note.ui.viewmodel.NoteViewModel
import com.ppb.note.util.Utilities.toEditable
import kotlinx.android.synthetic.main.default_note_fragment.*


class LongNoteFragment : Fragment() {
    companion object {
        const val TAG: String = "LongNoteFragment"
        private const val BUNDLE_NOTE_ID = "bundle_note_id"

        fun newInstance(id: Long): LongNoteFragment {
            val longNoteFragment = LongNoteFragment()
            val bundle = Bundle()
            bundle.putLong(BUNDLE_NOTE_ID, id)

            longNoteFragment.arguments = bundle
            return longNoteFragment
        }
    }

    private lateinit var noteViewModel: NoteViewModel
    private var _defaultNote: DefaultNote? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.default_note_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // note id from Note entity
        val noteId = arguments?.getLong(BUNDLE_NOTE_ID, 0) ?: 0

        // view model
        noteViewModel = ViewModelProvider(this, ViewModelProvider
                .AndroidViewModelFactory(activity!!.application))
                .get(NoteViewModel::class.java)

        noteViewModel.setNoteId(noteId)
        noteViewModel.defaultNote.observe(this) {
            if (it != null) {
                input_title.text = it.title.toEditable()
                input_body.text = it.body.toEditable()

                _defaultNote = it
            }
        }
    }

    fun getNote(): DefaultNote? {
        var defaultNote: DefaultNote? = _defaultNote

        if (validate()) {
            val title = input_title.text.toString().trim()
            val body = input_body.text.toString().trim()

            // insert
            if (defaultNote == null) {
                defaultNote = DefaultNote(body)
            }

            //update
            defaultNote.body = body
            defaultNote.title = title
        } else {
            Toast.makeText(context, "Judul atau isi tidak boleh kosong", Toast.LENGTH_SHORT).show()
        }

        return defaultNote
    }

    private fun validate(): Boolean {
        return when {
            input_title.text!!.isBlank() -> false
            input_body.text!!.isBlank() -> false
            else -> true
        }
    }
}