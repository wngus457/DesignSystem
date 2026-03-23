package com.juhyeon.androidds.ui.divider

import androidx.compose.runtime.Stable

sealed interface BasicDividerProperties

@Stable
sealed interface DividerAxisType : BasicDividerProperties {
    data object Horizontal : DividerAxisType
    data class Vertical(val heightType: DividerHeightType) : DividerAxisType
}

@Stable
sealed interface DividerHeightType : BasicDividerProperties {
    data object FillMaxHeight : DividerHeightType
    data class Height(val height: Int) : DividerHeightType
}

@Stable
sealed interface DividerThickness : BasicDividerProperties {
    data object Tiny : DividerThickness
    data object Small : DividerThickness
    data object Regular : DividerThickness
    data object Large : DividerThickness
}