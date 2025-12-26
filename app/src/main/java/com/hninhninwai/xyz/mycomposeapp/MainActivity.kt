package com.hninhninwai.xyz.mycomposeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.hninhninwai.xyz.mycomposeapp.navigations.BottomNavBar
import com.hninhninwai.xyz.mycomposeapp.navigations.BottomNavigationBar
import com.hninhninwai.xyz.mycomposeapp.navigations.NavGraph
import com.hninhninwai.xyz.mycomposeapp.navigations.Navigations
import com.hninhninwai.xyz.mycomposeapp.screens.CategoryScreen
import com.hninhninwai.xyz.mycomposeapp.screens.constraint_layout.ConstraintLayoutScreen
import com.hninhninwai.xyz.mycomposeapp.screens.constraint_layout.ConstraintScreen
import com.hninhninwai.xyz.mycomposeapp.screens.note.pages.NoteScreen
import com.hninhninwai.xyz.mycomposeapp.screens.note.repository.NoteRepository
import com.hninhninwai.xyz.mycomposeapp.screens.note.roomdb.NoteDB
import com.hninhninwai.xyz.mycomposeapp.screens.note.viewmodel.NoteViewModel
import com.hninhninwai.xyz.mycomposeapp.screens.note.viewmodel.NoteViewModelFactory

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Room DB
        val database = NoteDB.getInstance(applicationContext)
        // Repository
        val repository = NoteRepository(database.noteDao)
        // Viewmodel Factory
        val viewModelFactory = NoteViewModelFactory(repository)
        // View Model
        val noteViewModel = ViewModelProvider(this, viewModelFactory)[NoteViewModel::class.java]

        setContent {
//            val navController = rememberNavController()
//            Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {
//                NavGraph(navController = navController)
//            }
//            val navController = rememberNavController()
//            Scaffold(bottomBar = {
//                BottomNavBar(navController = navController)
//            }) {
//                Navigations(navController = navController)
//            }
//            ConstraintLayoutScreen()
//            ConstraintScreen()

            val notes by noteViewModel.getAllNotes.observeAsState(emptyList())

            NoteScreen(notes)
        }
    }
}