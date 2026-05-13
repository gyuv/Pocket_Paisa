package com.rork.pocketpaisa.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    gradientColors: List<Color>? = null,
    content: @Composable BoxScope.() -> Unit
) {
    val isDark = MaterialTheme.colorScheme.background == androidx.compose.ui.graphics.Color(0xFF0A0A0F)
    val cardBg = if (isDark) {
        Color(0xFF14141F).copy(alpha = 0.85f)
    } else {
        Color.White.copy(alpha = 0.85f)
    }
    val borderColor = if (isDark) {
        Color.White.copy(alpha = 0.08f)
    } else {
        Color.Black.copy(alpha = 0.06f)
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(
                brush = gradientColors?.let {
                    Brush.linearGradient(it)
                } ?: Brush.verticalGradient(
                    colors = listOf(cardBg, cardBg)
                )
            )
            .border(1.dp, borderColor, RoundedCornerShape(24.dp))
    ) {
        content()
    }
}
