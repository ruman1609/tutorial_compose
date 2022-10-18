package com.rudyrachman16.tutorialcompose.ui.birthday

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rudyrachman16.tutorialcompose.R
import com.rudyrachman16.tutorialcompose.ui.theme.TutorialComposeTheme


@Composable
fun BirthdayUI() {
    Image(
        painter = painterResource(R.drawable.androidparty),
        contentDescription = "Background",
        contentScale = ContentScale.Crop,
    )
    BirthdayGreetingText(
        message = stringResource(R.string.happy_birthday),
        stringResource(R.string.from_name, "Rudy")
    )
}

@Composable
private fun BirthdayGreetingText(message: String, from: String) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
            // bisa juga pake wrapContentWidth gini (set Gravity), tapi harus fillMaxWidth jua
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
            // bisa juga pake wrapContentWidth gini (set Gravity), tapi harus fillMaxWidth jua
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BirthdayPreview() {
    TutorialComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            BirthdayUI()
        }
    }
}