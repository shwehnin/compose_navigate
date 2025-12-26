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
fun DisplayDialog(viewModel: NoteViewModel, showDialog: Boolean, onDismiss: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var selectedColor by remember { mutableStateOf(Color.Black) }

    if (showDialog) {
        AlertDialog(onDismissRequest = onDismiss, confirmButton = {
            Button(
                onClick = {
                    var note = Note(
                        id = 0,
                        title = title,
                        description = description,
                        color = selectedColor.toArgb()
                    )
                    // Insert note into the DB
                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        viewModel.insertNote(note = note)
                    } else {
                        return@Button
                    }
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                )
            ) {
                Text("Submit")
            }
        }, dismissButton = {
            Button(
                onClick = onDismiss, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) { Text("Cancel") }
        }, title = {
            Text("Enter Note")
        }, text = {
            Column {
                OutlinedTextField(value = title, onValueChange = {
                    title = it
                }, label = {
                    Text("Enter Title")
                })
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(value = description, onValueChange = {
                    description = it
                }, label = {
                    Text("Enter Description")
                })
                Spacer(Modifier.height(16.dp))
            }
        })
    }
}