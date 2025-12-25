package com.hninhninwai.xyz.mycomposeapp.screens.constraint_layout

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.hninhninwai.xyz.mycomposeapp.R

@Composable
fun GradientBackground(modifier: Modifier) {
    Image(
        modifier = modifier.alpha(0.8f),
        painter = painterResource(id = R.drawable.bg),
        contentDescription = "Background Image",
        contentScale = ContentScale.FillBounds
    )
}