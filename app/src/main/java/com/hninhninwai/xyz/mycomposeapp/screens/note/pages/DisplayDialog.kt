package com.hninhninwai.xyz.mycomposeapp.screens.note.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.hninhninwai.xyz.mycomposeapp.screens.note.roomdb.Note
import com.hninhninwai.xyz.mycomposeapp.screens.note.viewmodel.NoteViewModel

@Composable
fun DisplayDialog(
    viewModel: NoteViewModel,
    showDialog: Boolean,
    onDismiss: () -> Unit,
    note: Note? = null
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var selectedColor by remember { mutableStateOf(Color.Black) }

    var titleError by remember { mutableStateOf(false) }
    var descriptionError by remember { mutableStateOf(false) }

    LaunchedEffect(note, showDialog) {
        if (showDialog) {
            if (note != null) {
                title = note.title
                description = note.description
                selectedColor = Color(note.color)
            } else {
                title = ""
                description = ""
                selectedColor = Color.Black
            }
            titleError = false
            descriptionError = false
        }
    }

    if (showDialog) {
        AlertDialog(onDismissRequest = onDismiss, confirmButton = {
            Button(
                onClick = {
                    titleError = false
                    descriptionError = false
                    var hasError = false

                    if (title.isEmpty() || title.isBlank()) {
                        titleError = true
                        hasError = true
                    }
                    if (description.isEmpty() || description.isBlank()) {
                        descriptionError = true
                        hasError = true
                    }
                    // Insert note into the DB
                    if (!hasError) {
                        val addNote = Note(
                            id = note?.id ?: 0,
                            title = title.trim(),
                            description = description.trim(),
                            color = selectedColor.toArgb()
                        )

                        if (note != null) {
                            viewModel.updateNote(note = addNote)
                        } else {
                            viewModel.insertNote(note = addNote)
                        }

                        title = ""
                        description = ""
                        selectedColor = Color.Black
                        onDismiss()
                    }
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                )
            ) {
                Text(if (note != null) "Update" else "Submit")
            }
        }, dismissButton = {
            Button(
                onClick = onDismiss, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) { Text("Cancel") }
        }, title = {
            Text(if (note != null) "Edit Note" else "Add Note")
        }, text = {
            Column {
                OutlinedTextField(value = title, onValueChange = {
                    title = it
                    if (titleError) titleError = false
                }, label = {
                    Text("Enter Title")
                }, isError = titleError, supportingText = {
                    if (titleError) {
                        Text("Title field is required", color = Color.Red)
                    }
                })
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(value = description, onValueChange = {
                    description = it
                    if (descriptionError) descriptionError = false
                }, label = {
                    Text("Enter Description")
                }, isError = descriptionError, supportingText = {
                    if (descriptionError) {
                        Text("Description field is required", color = Color.Red)
                    }
                })
                Spacer(Modifier.height(16.dp))
                MyColorPicker(
                    onColorSelected = { selectedColor = it },
                    selectedColor = selectedColor
                )
            }
        })
    }
}