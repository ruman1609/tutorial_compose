package com.rudyrachman16.tutorialcompose.tip

import org.junit.Assert
import org.junit.Test

class TipUIKtTest {
    @Test
    fun calculate_20_percent_tip_no_roundup() {
        val amount = 10000.0
        val tipPercent = 20.0
        val expectedTip = "IDR2,000.00"
        val actualTip = calculateTip(amount, tipPercent)
        Assert.assertEquals(expectedTip, actualTip)
    }
}