package com.juhyeon.androidds.ui.tooltip

import androidx.compose.runtime.Stable

sealed interface BasicTooltipProperties

@Stable
sealed interface TooltipHeader : BasicTooltipProperties {
    data class True(val title: String) : TooltipHeader
    data object False : TooltipHeader
}

@Stable
sealed interface TooltipColor : BasicTooltipProperties {
    data object Black : TooltipColor
    data object White : TooltipColor
}

@Stable
sealed interface TooltipPosition : BasicTooltipProperties {
    data object TopCenter : TooltipPosition
    data object TopStart : TooltipPosition
    data object TopEnd : TooltipPosition
    data object BottomCenter : TooltipPosition
    data object BottomStart : TooltipPosition
    data object BottomEnd : TooltipPosition
    data object StartCenter : TooltipPosition
    data object EndCenter : TooltipPosition
}