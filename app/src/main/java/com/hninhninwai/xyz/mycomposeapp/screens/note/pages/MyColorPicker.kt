package com.hninhninwai.xyz.mycomposeapp.screens.note.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

@Composable
fun MyColorPicker(selectedColor: Color, onColorSelected: (Color) -> Unit) {
    val colorList = listOf(
        Color("#E53935".toColorInt()),
        Color("#D81B60".toColorInt()),
        Color("#8E24AA".toColorInt()),
        Color("#5E35B1".toColorInt()),
        Color("#3949AB".toColorInt()),
        Color("#1E88E5".toColorInt()),
        Color("#039BE5".toColorInt()),
        Color("#00ACC1".toColorInt()),
        Color("#43A047".toColorInt()),
        Color("#7CB342".toColorInt()),
        Color("#C0CA33".toColorInt()),
        Color("#FDD835".toColorInt()),
        Color("#FFB300".toColorInt()),
        Color("#FB8C00".toColorInt()),
        Color("#F4511E".toColorInt()),
    )

    LazyRow(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier) {
        items(colorList) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .padding(4.dp)
                    .clip(
                        CircleShape
                    )
                    .background(color = it)
                    .border(
                        width = if (it == selectedColor) 4.dp else 0.dp,
                        color = if (it == selectedColor) Color.Black else Color.Transparent,
                        shape = CircleShape
                    )
                    .clickable { onColorSelected(it) }
            )
        }
    }
}