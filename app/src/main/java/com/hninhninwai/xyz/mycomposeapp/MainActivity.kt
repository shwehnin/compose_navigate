package com.hninhninwai.xyz.mycomposeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.hninhninwai.xyz.mycomposeapp.navigations.BottomNavigationBar
import com.hninhninwai.xyz.mycomposeapp.navigations.NavGraph

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {
                NavGraph(navController = navController)
            }
        }
    }
}