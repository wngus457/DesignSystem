package com.juhyeon.androidds.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

object BasicMaterialTheme {
    val colors: BasicColorScheme
        @Composable
        @ReadOnlyComposable
        get() = BasicLocalColorScheme.current
}

private val BasicLocalColorScheme = staticCompositionLocalOf { lightColorScheme() }

@Composable
fun BasicTheme(
    themeType: ThemeType = ThemeType.BasicLight,
    content: @Composable () -> Unit,
    disposableEffect: @Composable () -> Unit = { }
) {
    disposableEffect()
    val themeColor = when (themeType) {
        ThemeType.BasicLight -> lightColorScheme()
        ThemeType.BasicDark -> darkColorScheme()
    }

    MaterialTheme(
        content = {
            CompositionLocalProvider(
                BasicLocalColorScheme provides themeColor
            ) {
                Surface(content = content)
            }
        }
    )
}

sealed interface ThemeType {
    data object BasicLight : ThemeType
    data object BasicDark : ThemeType
}
