package com.hninhninwai.xyz.mycomposeapp.screens.constraint_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.hninhninwai.xyz.mycomposeapp.R

@Composable
fun LatestLessonText(modifier: Modifier) {
    Text(
        "Latest Lessons",
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SeeAllText(modifier: Modifier) {
    Text(
        "See All",
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        modifier = modifier,
        color = Color.Blue
    )
}

@Composable
fun LessonCard(modifier: Modifier) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
//                .padding(top = 16.dp, bottom = 16.dp)
                .wrapContentSize(Alignment.TopStart)
                .fillMaxHeight()
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {

                val (lessonDate, lessonTime, dateText, lessonImg, lessonTitle, lessonDesc) = createRefs()
                Text(
                    "Lesson Date",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Gray,
                    modifier = Modifier.constrainAs(lessonDate) {
                        top.linkTo(parent.top, margin = 20.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                    },
                )
                Icon(
                    Icons.Default.DateRange,
                    contentDescription = "Date",
                    modifier = Modifier.constrainAs(lessonTime) {
                        top.linkTo(lessonDate.bottom, margin = 8.dp)
                        start.linkTo(lessonDate.start)
                    })

                Text(
                    "Thur Dec 25 | 10:34 - 11:34 PM ",
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.constrainAs(dateText) {
                        top.linkTo(lessonTime.top)
                        start.linkTo(lessonTime.end, margin = 4.dp)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.java),
                    contentDescription = "Lesson Image",
                    modifier = Modifier.constrainAs(lessonImg) {
                        top.linkTo(lessonTime.bottom, margin = 16.dp)
                        start.linkTo(lessonTime.start)
                        bottom.linkTo(parent.bottom, margin = 16.dp)
                    }.size(60.dp),
                )

                Text(
                    "Data Structure & Algorithms",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.constrainAs(lessonTitle) {
                        top.linkTo(lessonImg.top)
                        start.linkTo(lessonImg.end, margin = 12.dp)
                    }
                )

                Text(
                    "To be a pro developer, you need to master structures and algorithms",
                    modifier = Modifier.padding(end = 4.dp).constrainAs(lessonDesc) {
                        top.linkTo(lessonTitle.bottom, 2.dp)
                        start.linkTo(lessonTitle.start)
                    },
                    fontSize = 14.sp,
                    color = Color.Gray,
                )
            }
        }
    }
}