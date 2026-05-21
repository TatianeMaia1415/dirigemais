package com.ufscar.dirigemais.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary            = DarkGreen,        // botões, TopAppBar, ícones ativos
    onPrimary          = SurfaceWhite,
    primaryContainer   = MintGreen,        // fundo de header, containers
    onPrimaryContainer = BrownText,
    secondary          = Amber,            // CTAs, chips selecionados
    onSecondary        = BrownText,
    secondaryContainer = Color(0xFFFFF3CD),
    background         = BackgroundMint,
    onBackground       = BrownText,
    surface            = SurfaceWhite,
    onSurface          = BrownText,
    surfaceVariant     = GrayField,
    onSurfaceVariant   = BrownTextLight,
    outline            = GrayBorder,
    error              = Color(0xFFB00020)
)

private val DarkColorScheme = darkColorScheme(
    primary          = MintGreen,
    onPrimary        = DarkGreenDark,
    secondary        = Amber,
    background       = DarkBackground,
    surface          = DarkSurface,
    onBackground     = SurfaceWhite,
    onSurface        = SurfaceWhite
)

@Composable
fun DirigeMaisTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primaryContainer.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = Typography,
        content     = content
    )
}
