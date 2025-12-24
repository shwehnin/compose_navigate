package com.hninhninwai.xyz.mycomposeapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CategoryScreen(navigateToProduct: (Int, Boolean) -> Unit, navigateToCart: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Categories")
        Button(onClick = { navigateToProduct(20, true) }) {
            Text("Go to Product")
        }
        Button(onClick = navigateToCart) {
            Text("Go to Cart")
        }
    }
}