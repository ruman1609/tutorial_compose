package com.rudyrachman16.tutorialcompose.tip

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rudyrachman16.tutorialcompose.R
import com.rudyrachman16.tutorialcompose.ui.theme.Purple500
import com.rudyrachman16.tutorialcompose.ui.theme.TutorialComposeTheme
import java.text.NumberFormat
import kotlin.math.ceil


@Composable
fun TipUI() {
    var amountInput by remember { mutableStateOf("") }
    var tipPercentInput by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }

    val amount = amountInput.toDoubleOrNull() ?: .0
    val tipPercent = tipPercentInput.toDoubleOrNull() ?: .0
    val tip = calculateTip(amount, tipPercent, roundUp)

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 24.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.calculate_tip),
            textAlign = TextAlign.Center, fontSize = 20.sp,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 20.dp)
        )
        CanOnEditTextField(
            label = stringResource(R.string.cost_of_service),
            value = amountInput, imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
        ) { amountInput = it }
        Spacer(modifier = Modifier.height(4.dp))
        CanOnEditTextField(
            label = stringResource(R.string.how_was_the_service),
            value = tipPercentInput, imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
        ) { tipPercentInput = it }
        SpinnerWithLabel(checked = roundUp) { roundUp = it }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(R.string.tip_amount, tip),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun SpinnerWithLabel(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            checked = checked, onCheckedChange = onCheckedChange, colors = SwitchDefaults.colors(
                checkedThumbColor = Purple500,
                uncheckedThumbColor = Color.LightGray
            )
        )
    }
}

@Composable
private fun CanOnEditTextField(
    label: String, value: String,
    imeAction: ImeAction, keyboardActions: KeyboardActions,
    onChangeListener: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onChangeListener,
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged {
                if (it.hasFocus) onChangeListener("")
            },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number, imeAction = imeAction
        ),
        keyboardActions = keyboardActions,
        singleLine = true,
        label = { Text(label) },
    )
}

@VisibleForTesting
internal fun calculateTip(
    amount: Double, tipPercent: Double = 15.0, roundUp: Boolean = false
): String =
    NumberFormat.getCurrencyInstance()
        .format(if (roundUp) ceil(tipPercent / 100 * amount) else tipPercent / 100 * amount)

@Preview(showBackground = true)
@Composable
private fun TipUIPreview() {
    TutorialComposeTheme {
        Surface {
            TipUI()
        }
    }
}