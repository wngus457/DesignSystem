package com.juhyeon.androidds.ui.button.basic

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable
import com.juhyeon.androidds.ui.icon.basic.BasicIconSize

sealed interface BasicButtonProperties

@Stable
sealed interface ButtonStyle : BasicButtonProperties {
    data object Solid : ButtonStyle
    data object Outlined : ButtonStyle
}

@Stable
sealed interface ButtonSize : BasicButtonProperties {
    data object Small : ButtonSize
    data object Medium : ButtonSize
    data object Large : ButtonSize
}

@Stable
sealed interface ButtonIcon : BasicButtonProperties {
    data object False : ButtonIcon
    data class True(
        @param:DrawableRes val icon: Int,
        val size: BasicIconSize = BasicIconSize.Small
    ) : ButtonIcon
}

@Stable
sealed interface ButtonState : BasicButtonProperties {
    data object Enabled : ButtonState
    data object Disabled : ButtonState
}

@Stable
sealed interface ButtonClickType : BasicButtonProperties {
    data object NormalInteraction : ButtonClickType
    data object Normal : ButtonClickType
    data object SingleInteraction : ButtonClickType
    data object Single : ButtonClickType
}