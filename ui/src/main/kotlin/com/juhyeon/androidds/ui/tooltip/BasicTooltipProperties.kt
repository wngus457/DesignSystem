package com.juhyeon.androidds.ui.tooltip

sealed interface BasicTooltipProperties

sealed interface TooltipHeader : BasicTooltipProperties {
    data class True(val title: String) : TooltipHeader
    data object False : TooltipHeader
}

sealed interface TooltipColor : BasicTooltipProperties {
    data object Black : TooltipColor
    data object White : TooltipColor
}

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