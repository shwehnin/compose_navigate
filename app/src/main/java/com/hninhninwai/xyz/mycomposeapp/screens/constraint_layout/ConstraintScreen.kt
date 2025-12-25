package com.hninhninwai.xyz.mycomposeapp.screens.constraint_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
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
        val (gradientBg, profileImg, notificationImg) = createRefs()

        // Guideline
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

        val topGuideline = createGuidelineFromTop(16.dp)
        val startGuideline = createGuidelineFromStart(16.dp)
        val endGuideline = createGuidelineFromEnd(16.dp)

        // Chain
        createHorizontalChain(profileImg, notificationImg, chainStyle = ChainStyle.SpreadInside)

        ProfileImage(modifier = Modifier.constrainAs(profileImg) {
            top.linkTo(topGuideline)
        })

        NotificationIcon(modifier = Modifier.constrainAs(notificationImg) {
            top.linkTo(profileImg.top)
            bottom.linkTo(profileImg.bottom)
        })
    }
}