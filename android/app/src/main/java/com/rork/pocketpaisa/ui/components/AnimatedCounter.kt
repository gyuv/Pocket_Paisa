package com.rork.pocketpaisa.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import java.text.NumberFormat
import java.util.Locale

@Composable
fun AnimatedCounter(
    targetValue: Double,
    modifier: Modifier = Modifier,
    prefix: String = "",
    suffix: String = "",
    style: TextStyle = MaterialTheme.typography.displayMedium,
    color: Color = MaterialTheme.colorScheme.onBackground,
    durationMillis: Int = 1200
) {
    val animatedValue = remember { Animatable(0f) }
    val numberFormat = NumberFormat.getCurrencyInstance(Locale("en", "IN"))

    LaunchedEffect(targetValue) {
        animatedValue.animateTo(
            targetValue.toFloat(),
            animationSpec = tween(durationMillis)
        )
    }

    val formattedValue = numberFormat.format(animatedValue.value.toDouble())

    Text(
        text = "$prefix$formattedValue$suffix",
        style = style,
        color = color,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun AnimatedPercentage(
    targetValue: Float,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.headlineMedium,
    color: Color = MaterialTheme.colorScheme.onBackground,
    durationMillis: Int = 1000
) {
    val animatedValue = remember { Animatable(0f) }

    LaunchedEffect(targetValue) {
        animatedValue.animateTo(
            targetValue,
            animationSpec = tween(durationMillis)
        )
    }

    Text(
        text = "${animatedValue.value.toInt()}",
        style = style,
        color = color,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}
