package com.tagihan.app.design

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape

// Colors
private val Primary = Color(0xFF3F5BFF)
private val Secondary = Color(0xFF00C2A8)
private val Tertiary = Color(0xFFFFB703)

private val LightColors: ColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = Color.White,
    secondary = Secondary,
    tertiary = Tertiary,
)

private val DarkColors: ColorScheme = darkColorScheme(
    primary = Primary,
    onPrimary = Color.White,
    secondary = Secondary,
    tertiary = Tertiary,
)

// Typography
private val AppTypography = Typography(
    titleLarge = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.SemiBold),
    titleMedium = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold),
    titleSmall = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium),
    bodyLarge = TextStyle(fontSize = 16.sp),
    bodyMedium = TextStyle(fontSize = 14.sp),
    labelLarge = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
)

// Shapes
private val AppShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp)
)

// Spacing tokens
data class Spacing(
    val xs: Dp = 4.dp,
    val sm: Dp = 8.dp,
    val md: Dp = 12.dp,
    val lg: Dp = 16.dp,
    val xl: Dp = 24.dp,
    val xxl: Dp = 32.dp
)

val LocalSpacing = staticCompositionLocalOf { Spacing() }

// Elevation tokens
data class Elevations(
    val level0: Dp = 0.dp,
    val level1: Dp = 1.dp,
    val level2: Dp = 3.dp,
    val level3: Dp = 6.dp,
    val level4: Dp = 8.dp,
    val level5: Dp = 12.dp
)

val LocalElevations = staticCompositionLocalOf { Elevations() }

@Composable
fun TagihanTheme(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    val colors = if (darkTheme) DarkColors else LightColors
    CompositionLocalProvider(
        LocalSpacing provides Spacing(),
        LocalElevations provides Elevations(),
    ) {
        MaterialTheme(
            colorScheme = colors,
            typography = AppTypography,
            shapes = AppShapes,
            content = content
        )
    }
}
