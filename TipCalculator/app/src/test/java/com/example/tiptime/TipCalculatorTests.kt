package com.example.tiptime

import org.junit.Test
import org.junit.Assert.assertEquals
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTipo_20PercentNoRoundup() {
        val amount = 10.0
        val tipPercent = 20.0

        val actualTip = calculateTip(amount, tipPercent, false)

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        assertEquals(expectedTip, actualTip)
    }
}