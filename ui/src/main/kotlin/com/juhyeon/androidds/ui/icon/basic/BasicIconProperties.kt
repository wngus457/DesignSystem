package com.juhyeon.androidds.ui.icon.basic

import androidx.compose.runtime.Stable

sealed interface BasicIconProperties

@Stable
sealed interface BasicIconSize : BasicIconProperties {
    data object Tiny : BasicIconSize
    data object Small : BasicIconSize
    data object Regular : BasicIconSize
    data object Medium : BasicIconSize
    data object Large : BasicIconSize
}