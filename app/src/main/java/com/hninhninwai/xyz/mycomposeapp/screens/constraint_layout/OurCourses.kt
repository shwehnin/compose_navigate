package com.hninhninwai.xyz.mycomposeapp.screens.constraint_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hninhninwai.xyz.mycomposeapp.R

@Composable
fun TextOurCourses(modifier: Modifier) {
    Text(
        "New Courses",
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun JavaCourseImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.java),
        contentDescription = "Java Course",
        modifier = modifier.size(70.dp)
    )
}

@Composable
fun PythonCourseImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.python),
        contentDescription = "Python Course",
        modifier = modifier.size(70.dp)
    )
}

@Composable
fun AndroidCourseImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.android),
        contentDescription = "Android Course",
        modifier = modifier.size(70.dp)
    )
}

@Composable
fun AndroidText(modifier: Modifier) {
    Text("Android", style = MaterialTheme.typography.titleMedium, modifier = modifier)
}

@Composable
fun JavaText(modifier: Modifier) {
    Text("Java", style = MaterialTheme.typography.titleMedium, modifier = modifier)
}

@Composable
fun PythonText(modifier: Modifier) {
    Text("Python", style = MaterialTheme.typography.titleMedium, modifier = modifier)
}