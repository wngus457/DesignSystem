package com.juhyeon.androidds.ui.input.basic

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.juhyeon.androidds.ui.theme.Palette

sealed interface BasicInputFieldProperties

sealed interface InputFieldState : BasicInputFieldProperties {
    data object Enabled : InputFieldState
    data object Active : InputFieldState
    data object Done : InputFieldState
    data object Error : InputFieldState
}

sealed interface InputFieldEnabled : BasicInputFieldProperties {
    data object Enabled : InputFieldEnabled
    data object Disabled : InputFieldEnabled
}

sealed interface InputFieldPlaceholder : BasicInputFieldProperties {
    data class True(val text: String) : InputFieldPlaceholder
    data object False : InputFieldPlaceholder
}

sealed interface InputFieldType : BasicInputFieldProperties {
    data object Normal : InputFieldType
    data class Icon(@param:DrawableRes val icon: Int, val tint: Color = Palette.Neutral10) : InputFieldType
    data class Text(val text: String) : InputFieldType
}