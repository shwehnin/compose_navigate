package com.hninhninwai.xyz.mycomposeapp.screens.note.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.hninhninwai.xyz.mycomposeapp.screens.note.repository.NoteRepository
import com.hninhninwai.xyz.mycomposeapp.screens.note.roomdb.Note
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {
    val getAllNotes: LiveData<List<Note>> = repository.getAllNotes

    fun insertNote(note: Note) = viewModelScope.launch {
        repository.insertNote(note)
    }

    fun getNoteById(noteId: Int): LiveData<Note?> = repository.getNoteById(noteId)

    fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNote(note)
    }
}