package com.rudyrachman16.tutorialcompose.ui.practice_component_basic

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rudyrachman16.tutorialcompose.R
import com.rudyrachman16.tutorialcompose.ui.theme.TutorialComposeTheme

@Composable
fun PracticeComponentBasic() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = "Background",
            modifier = Modifier.fillMaxWidth()
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.jetpack_compose),
                fontSize = 24.sp,
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
            )
            Text(
                text = stringResource(id = R.string.jetpack_compose_desc_1),
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp), textAlign = TextAlign.Justify
            )
            Text(
                text = stringResource(id = R.string.jetpack_compose_desc_2),
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp), textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun TaskManager() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = "Completed!"
        )
        Text(
            text = stringResource(id = R.string.all_task_completed),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(0.dp, 24.dp, 0.dp, 8.dp)
        )
        Text(
            text = stringResource(id = R.string.nice_work),
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp), textAlign = TextAlign.Justify
        )
    }
}

@Composable
private fun QuadrantText(title: String, desc: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp).fillMaxSize()
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
        )
        Text(text = desc, textAlign = TextAlign.Justify)
    }
}

@Composable
fun Quadrant() {
    Column(modifier = Modifier.fillMaxHeight()) {
        Row(modifier = Modifier.weight(weight = .5f)) {
            Column(
                modifier = Modifier
                    .background(color = Color.Green)
                    .weight(weight = .5f)
            ) {
                QuadrantText(
                    stringResource(R.string.quadrant_1),
                    stringResource(R.string.quadrant_1_desc)
                )
            }
            Column(
                modifier = Modifier
                    .background(color = Color.Yellow)
                    .weight(weight = .5f)
            ) {
                QuadrantText(
                    stringResource(R.string.quadrant_2),
                    stringResource(R.string.quadrant_2_desc)
                )
            }
        }
        Row(modifier = Modifier.weight(weight = .5f)) {
            Column(
                modifier = Modifier
                    .background(color = Color.Cyan)
                    .weight(weight = .5f)
            ) {
                QuadrantText(
                    stringResource(R.string.quadrant_3),
                    stringResource(R.string.quadrant_3_desc)
                )
            }
            Column(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .weight(weight = .5f)
            ) {
                QuadrantText(
                    stringResource(R.string.quadrant_4),
                    stringResource(R.string.quadrant_4_desc)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PracticeComponentReview() {
    TutorialComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
//            PracticeComponentBasic()
//            TaskManager()
            Quadrant()
        }
    }
}
