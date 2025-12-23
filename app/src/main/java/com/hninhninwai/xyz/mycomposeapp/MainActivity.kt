package com.hninhninwai.xyz.mycomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // 1 - NavController : Navigating between composables
            val navController = rememberNavController()

            // 2 - NavHost : Defines the nav graph, start & composable destinations
            NavHost(navController = navController, startDestination = "first") {
                composable("first") { FirstScreen(navController = navController) }
                composable(
                    route = "second/{name}?age={age}", arguments = listOf(
                        navArgument("name") {
                            type = NavType.StringType
                        },
                        navArgument("age") {
                            type = NavType.StringType
                            defaultValue = "30"
                            nullable = true
                        }
                    )) { backStackEntry ->
                    SecondScreen(
                        navController = navController,
                        backStackEntry.arguments?.getString("name").toString(),
                        backStackEntry.arguments?.getString("age").toString()
                    )
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is first page")
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name, onValueChange = { name = it }, label = { Text("Enter your name") })
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = age,
            onValueChange = { newAge -> age = newAge },
            label = { Text("Enter your age") })
        Spacer(Modifier.height(8.dp))
        Button(onClick = {
            // 1 - Passing the entered name and age as arguments
            navController.navigate("second/$name?age=$age")
        }) {
            Text("Go to Second Screen")
        }
    }
}

@Composable
fun SecondScreen(navController: NavController, name: String, age: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome $name and your age is $age")
        Spacer(Modifier.height(8.dp))
        Button(onClick = {
            navController.navigateUp()
        }) {
            Text("Go Back")
        }
    }
}