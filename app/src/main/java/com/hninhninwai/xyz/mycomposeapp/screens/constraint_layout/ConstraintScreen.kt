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
        val (gradientBg, profileImg, notificationImg, welcomeText, questionText, joinNow, courseImg, myCard, textCourses, androidCourseImg, javaCourseImg, pythonCourseImg, androidText, javaText, pythonText, latestLessonText) = createRefs()

        val (seeAllText, lessonCard) = createRefs()
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

        WelcomeText(modifier = Modifier.constrainAs(welcomeText) {
            top.linkTo(profileImg.bottom, margin = 16.dp)
            start.linkTo(startGuideline)
        })

        QuestionText(modifier = Modifier.constrainAs(questionText) {
            top.linkTo(welcomeText.bottom)
            start.linkTo(welcomeText.start)
        })

        JoinNow(modifier = Modifier.constrainAs(joinNow) {
            top.linkTo(questionText.bottom, margin = 16.dp)
            start.linkTo(questionText.start)
            end.linkTo(questionText.end)
        }, onClick = {})

        CoursesImage(modifier = Modifier.constrainAs(courseImg) {
            bottom.linkTo(horizontalGuideline1, margin = 36.dp)
            end.linkTo(endGuideline)
//            start.linkTo(joinNow.end, margin = 8.dp)
            top.linkTo(joinNow.bottom)
            height = Dimension.fillToConstraints
            width = Dimension.value(200.dp)
        })

        MyCard(modifier = Modifier.constrainAs(myCard) {
            top.linkTo(horizontalGuideline1, margin = (-32).dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })

        TextOurCourses(modifier = Modifier.constrainAs(textCourses) {
            top.linkTo(myCard.top, margin = 16.dp)
            start.linkTo(myCard.start, margin = 16.dp)
        })

        createHorizontalChain(
            androidCourseImg, javaCourseImg, pythonCourseImg, chainStyle = ChainStyle.Spread
        )

        AndroidCourseImage(modifier = Modifier.constrainAs(androidCourseImg) {
            top.linkTo(textCourses.bottom, margin = 16.dp)
        })
        JavaCourseImage(modifier = Modifier.constrainAs(javaCourseImg) {
            top.linkTo(androidCourseImg.top)
            bottom.linkTo(androidCourseImg.bottom)
        })
        PythonCourseImage(modifier = Modifier.constrainAs(pythonCourseImg) {
            top.linkTo(androidCourseImg.top)
            bottom.linkTo(androidCourseImg.bottom)
        })

        AndroidText(modifier = Modifier.constrainAs(androidText) {
            top.linkTo(androidCourseImg.bottom, margin = 12.dp)
            start.linkTo(androidCourseImg.start)
            end.linkTo(androidCourseImg.end)
        })

        JavaText(modifier = Modifier.constrainAs(javaText) {
            top.linkTo(javaCourseImg.bottom, margin = 12.dp)
            start.linkTo(javaCourseImg.start)
            end.linkTo(javaCourseImg.end)
        })

        PythonText(modifier = Modifier.constrainAs(pythonText) {
            top.linkTo(pythonCourseImg.bottom, margin = 12.dp)
            start.linkTo(pythonCourseImg.start)
            end.linkTo(pythonCourseImg.end)
        })

        LatestLessonText(modifier = Modifier.constrainAs(latestLessonText) {
            top.linkTo(androidText.bottom, margin = 20.dp)
            start.linkTo(startGuideline)
        })

        SeeAllText(modifier = Modifier.constrainAs(seeAllText) {
            top.linkTo(latestLessonText.top)
            end.linkTo(endGuideline)
        })

        LessonCard(modifier = Modifier.constrainAs(lessonCard) {
            top.linkTo(latestLessonText.bottom, margin = 16.dp)
            start.linkTo(startGuideline)
            end.linkTo(endGuideline)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        })
    }
}