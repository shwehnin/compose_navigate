package com.hninhninwai.xyz.mycomposeapp.screens.note.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hninhninwai.xyz.mycomposeapp.screens.note.viewmodel.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetailScreen(noteId: Int, viewModel: NoteViewModel, onNavigateBack: () -> Unit) {

    val note by viewModel.getNoteById(noteId).observeAsState()
    var showEditDialog by remember { mutableStateOf(false) }

    if (note != null) {
        DisplayDialog(
            viewModel = viewModel,
            showDialog = showEditDialog,
            onDismiss = { showEditDialog = false },
            note = note
        )
    }

    if (note == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        return
    }

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Note Details") }, navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            }, actions = {
                IconButton(onClick = {
                    showEditDialog = true
                }) { Icon(Icons.Default.Edit, contentDescription = "Edit") }
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Black,
                titleContentColor = Color.White,
                navigationIconContentColor = Color.White,
                actionIconContentColor = Color.White
            )
        )
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            Card(
                elevation = CardDefaults.cardElevation(4.dp),
                modifier = Modifier
                    .padding(8.dp)
                    .clip(shape = RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = Color(note!!.color),
                    contentColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = note!!.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(
                        text = note!!.description,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }
        }
    }
}