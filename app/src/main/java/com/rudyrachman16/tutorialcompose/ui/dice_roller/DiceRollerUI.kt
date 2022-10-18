package com.rudyrachman16.tutorialcompose.ui.dice_roller

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rudyrachman16.tutorialcompose.R
import com.rudyrachman16.tutorialcompose.ui.theme.TutorialComposeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DiceRoller() {
    val diceDrawable: Array<Painter> = arrayOf(
        painterResource(id = R.drawable.dice_1),
        painterResource(id = R.drawable.dice_2),
        painterResource(id = R.drawable.dice_3),
        painterResource(id = R.drawable.dice_4),
        painterResource(id = R.drawable.dice_5),
        painterResource(id = R.drawable.dice_6)
    )
    val diceContent: Array<String> = arrayOf(
        stringResource(id = R.string.dice_1),
        stringResource(id = R.string.dice_2),
        stringResource(id = R.string.dice_3),
        stringResource(id = R.string.dice_4),
        stringResource(id = R.string.dice_5),
        stringResource(id = R.string.dice_6),
    )

    var result by remember { mutableStateOf(0) }
    var randomize by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center)
    ) {
        Image(
            painter = diceDrawable[result],
            contentDescription = diceContent[result]
        )
        Button(onClick = {
            coroutineScope.launch(Dispatchers.IO) {
                randomize = true
                launch(Dispatchers.Main) {
                    while (randomize) {
                        delay(50)
                        result = (0..5).random()
                    }
                }
                delay(1000)
                randomize = false
            }
        }, enabled = !randomize) {
            Text(text = stringResource(id = R.string.roll))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DiceRollerPreview() {
    TutorialComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            DiceRoller()
        }
    }
}