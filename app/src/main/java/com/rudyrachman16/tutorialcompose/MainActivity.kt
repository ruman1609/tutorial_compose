package com.rudyrachman16.tutorialcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rudyrachman16.tutorialcompose.ui.birthday.BirthdayUI
import com.rudyrachman16.tutorialcompose.ui.dice_roller.DiceRoller
import com.rudyrachman16.tutorialcompose.ui.theme.TutorialComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DiceRoller()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, color: Color) {
    Column(
        modifier = Modifier
            .background(color = color)
            .fillMaxWidth()
    ) {
        Text(
            text = "Hello $name!",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TutorialComposeTheme {
        Greeting("Liong", Color.LightGray)
    }
}