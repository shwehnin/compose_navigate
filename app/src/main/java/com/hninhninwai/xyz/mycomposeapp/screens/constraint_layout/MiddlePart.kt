package com.hninhninwai.xyz.mycomposeapp.screens.constraint_layout

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hninhninwai.xyz.mycomposeapp.R

@Composable
fun WelcomeText(modifier: Modifier) {
    Text(
        "Welcome Back!",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = modifier
    )
}

@Composable
fun QuestionText(modifier: Modifier) {
    Text(
        "What do you want to learn?",
        style = MaterialTheme.typography.titleMedium,
        color = Color.White,
        modifier = modifier
    )
}

@Composable
fun JoinNow(modifier: Modifier, onClick: () -> Unit) {
    Button(onClick = { onClick() }, modifier = modifier) {
        Text("Join Now!")
    }
}

@Composable
fun CoursesImage(modifier: Modifier) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(12.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.course),
            contentDescription = "Course Image",
            contentScale = ContentScale.Crop
        )
    }
}