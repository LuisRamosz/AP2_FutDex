
package com.example.ap2futdex.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val FutDexColorScheme = darkColorScheme(
    primary = VerdeFutDex,
    secondary = VerdeFutDexClaro,
    tertiary = CinzaFutDex,
    background = FundoFutDex,
    surface = CardFutDex,
    onPrimary = TextoFutDexEscuro,
    onSecondary = TextoFutDexEscuro,
    onTertiary = TextoFutDexEscuro,
    onBackground = BrancoFutDex,
    onSurface = BrancoFutDex
)

@Composable
fun AP2FutDexTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = FutDexColorScheme,
        typography = Typography,
        content = content
    )
}
