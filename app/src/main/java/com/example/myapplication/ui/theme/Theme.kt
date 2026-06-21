package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Light Theme Colors
private val LightColors = lightColorScheme(
    primary = PrimaryBlue,
    onPrimary = Surface,
    secondary = SelectedBlue,
    onSecondary = TextPrimary,
    background = Background,
    onBackground = TextPrimary,
    surface = Surface,
    onSurface = TextPrimary,
    surfaceVariant = BottomBar,
    onSurfaceVariant = TextSecondary,
    error = Color(0xFFB00020),
    onError = Color.White
)

// Dark Theme Colors (auto-derived since no dark palette was provided)
private val DarkColors = darkColorScheme(
    primary = SelectedBlue,
    onPrimary = TextPrimary,
    secondary = PrimaryBlue,
    onSecondary = Surface,
    background = Color(0xFF121212),
    onBackground = Color(0xFFF5F6F8),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFF5F6F8),
    surfaceVariant = Color(0xFF2A2A2E),
    onSurfaceVariant = TextLight,
    error = Color(0xFFCF6679),
    onError = Color.Black
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColors
    } else {
        LightColors
    }

    //    Screen Background -> background
    //    Text on screen -> onBackground
    //
    //    Button Background -> primary
    //    Text on button -> onPrimary
    //
    //    Card Background -> surface
    //    Text on card -> onSurface
    //
    //    Bottom bar -> surfaceVariant
    //    Secondary/light text -> onSurfaceVariant or TextLight
    //
    //    Error message -> error

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(),
        content = content
    )
}