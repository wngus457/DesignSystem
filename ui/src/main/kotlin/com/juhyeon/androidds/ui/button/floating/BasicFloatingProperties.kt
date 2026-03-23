package com.juhyeon.androidds.ui.button.floating

import androidx.compose.runtime.Stable

sealed interface BasicFloatingProperties

@Stable
sealed interface FloatingStyle : BasicFloatingProperties {
    data object Filled : FloatingStyle
    data object Outlined : FloatingStyle
}

@Stable
sealed interface FloatingSize : BasicFloatingProperties {
    data object Regular : FloatingSize
    data object Large : FloatingSize
}

@Stable
sealed interface FloatingState : BasicFloatingProperties {
    data object Enabled : FloatingState
    data object Disabled : FloatingState
}