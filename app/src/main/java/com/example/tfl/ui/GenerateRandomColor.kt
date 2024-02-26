package com.example.tfl.ui

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

fun generateRandomColor(): Color {
    val random = Random.Default
    return Color(random.nextInt(256), random.nextInt(256), random.nextInt(256))
}