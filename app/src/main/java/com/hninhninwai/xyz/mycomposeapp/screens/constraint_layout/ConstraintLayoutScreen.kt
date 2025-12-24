package com.hninhninwai.xyz.mycomposeapp.screens.constraint_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (box1, box2, text) = createRefs()

        val guideline1 = createGuidelineFromStart(0.15f)

        Box(
            modifier = Modifier
                .background(color = Color.Red)
                .size(100.dp)
                .constrainAs(box1) {
                    top.linkTo(parent.top, margin = 100.dp)
                    start.linkTo(guideline1)
                },
        )

        Box(
            modifier = Modifier
                .size(250.dp)
                .background(color = Color.Green)
                .constrainAs(
                    box2
                ) {
                    top.linkTo(box1.bottom, margin = 20.dp)
                    start.linkTo(guideline1)
                },
        )

        Text(
            "Hello Constraint Layout",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(box2.bottom, margin = 16.dp)
                start.linkTo(guideline1)
            },
        )
    }
}