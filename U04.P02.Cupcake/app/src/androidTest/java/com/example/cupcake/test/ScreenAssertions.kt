package com.example.cupcake.test

import androidx.navigation.NavController
import com.example.cupcake.CupcakeScreen
import org.junit.Assert.assertEquals

fun NavController.assertCurrentRouteName(expectedRoute: CupcakeScreen) {
    assertEquals(currentBackStackEntry?.destination?.route, expectedRoute.name)
}