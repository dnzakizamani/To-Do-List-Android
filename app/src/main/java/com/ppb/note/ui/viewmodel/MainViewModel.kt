package com.ppb.note.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ppb.note.model.MixNote
import com.ppb.note.repository.NoteRepository


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = NoteRepository.getInstance(application)

    val mixNote: LiveData<MixNote> = repository.getMixNote()
}