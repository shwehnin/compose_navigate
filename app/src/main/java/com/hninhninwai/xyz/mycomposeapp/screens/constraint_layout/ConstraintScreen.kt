package com.hninhninwai.xyz.mycomposeapp.screens.constraint_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ConstraintScreen() {
    ConstraintLayout(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val (gradientBg) = createRefs()

        val horizontalGuideline1 = createGuidelineFromTop(0.45f)

        GradientBackground(
            modifier = Modifier.constrainAs(gradientBg) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(horizontalGuideline1)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            },
        )
    }
}