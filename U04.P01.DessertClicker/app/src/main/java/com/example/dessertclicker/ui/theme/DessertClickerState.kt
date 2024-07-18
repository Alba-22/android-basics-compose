package com.example.dessertclicker.ui.theme

import androidx.annotation.DrawableRes

data class DessertClickerState (
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertPrice: Int = 0,
    @DrawableRes val currentDessertImageId: Int = 0
)