package com.juhyeon.androidds.ui.button.text

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.juhyeon.androidds.ui.theme.Palette

sealed interface BasicTextButtonProperties

@Stable
sealed interface TextButtonSize : BasicTextButtonProperties {
    data object Small : TextButtonSize
    data object Large : TextButtonSize
}

@Stable
sealed interface TextButtonEnabled : BasicTextButtonProperties {
    data object Enabled : TextButtonEnabled
    data object Disabled : TextButtonEnabled
}

@Stable
sealed interface TextButtonIcon : BasicTextButtonProperties {
    data object False : TextButtonIcon
    data class Right(@param:DrawableRes val icon: Int, val tint: Color = Palette.Neutral10) : TextButtonIcon
    data class Left(@param:DrawableRes val icon: Int, val tint: Color = Palette.Neutral10) : TextButtonIcon
}