package com.rudyrachman16.tutorialcompose

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.rudyrachman16.tutorialcompose.tip.TipUI
import com.rudyrachman16.tutorialcompose.ui.theme.TutorialComposeTheme
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.apply {
            setContent {
                TutorialComposeTheme {
                    TipUI()
                }
            }
            onNodeWithText("Cost of Service").performTextInput("10")
            onNodeWithText("Tip (%)").performTextInput("20")
            onNodeWithText("Tip amount: $2.00").assertExists()
        }
    }
}