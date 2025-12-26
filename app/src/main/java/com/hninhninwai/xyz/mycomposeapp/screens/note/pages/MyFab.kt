package com.hninhninwai.xyz.mycomposeapp.screens.note.pages

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.hninhninwai.xyz.mycomposeapp.screens.note.viewmodel.NoteViewModel

@Composable
fun MyFab(viewModel: NoteViewModel) {
    var showDialog by remember { mutableStateOf(false) }

    DisplayDialog(
        viewModel = viewModel,
        showDialog = showDialog,
        note = null,
        onDismiss = { showDialog = false })

    FloatingActionButton(
        onClick = { showDialog = true },
        containerColor = Color.Black,
        contentColor = Color.White
    ) {
        Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
    }
}