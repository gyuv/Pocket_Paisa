package com.rork.pocketpaisa.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val ElectricBlue = Color(0xFF00D4FF)
val NeonGreen = Color(0xFF39FF14)
val LuxuryPurple = Color(0xFF8B5CF6)
val DeepNavy = Color(0xFF0A1628)
val MatteBlack = Color(0xFF0A0A0F)
val SoftWhite = Color(0xFFFAFAFA)
val WarmGray = Color(0xFFF5F5F7)
val Gold = Color(0xFFFFD700)
val Rose = Color(0xFFFF6B9D)
val Teal = Color(0xFF00D9C0)
val Orange = Color(0xFFFF9F43)
val Danger = Color(0xFFFF4757)
val Success = Color(0xFF2ED573)

private val DarkColorScheme = darkColorScheme(
    primary = ElectricBlue,
    onPrimary = Color.Black,
    secondary = NeonGreen,
    onSecondary = Color.Black,
    tertiary = LuxuryPurple,
    onTertiary = Color.White,
    background = MatteBlack,
    onBackground = Color.White,
    surface = Color(0xFF14141F),
    onSurface = Color.White,
    surfaceVariant = Color(0xFF1E1E2E),
    onSurfaceVariant = Color(0xFFB0B0C0),
    outline = Color(0xFF2A2A3A),
    error = Danger,
    onError = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF0066CC),
    onPrimary = Color.White,
    secondary = Color(0xFF00AA66),
    onSecondary = Color.White,
    tertiary = LuxuryPurple,
    onTertiary = Color.White,
    background = SoftWhite,
    onBackground = Color(0xFF1A1A2E),
    surface = Color.White,
    onSurface = Color(0xFF1A1A2E),
    surfaceVariant = WarmGray,
    onSurfaceVariant = Color(0xFF6B6B7B),
    outline = Color(0xFFE0E0E8),
    error = Danger,
    onError = Color.White
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) DarkColorScheme else LightColorScheme
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = PocketPaisaTypography,
        content = content
    )
}
