package com.juhyeon.androidds.ui.control.radio

import androidx.compose.runtime.Stable

sealed interface BasicRadioButtonProperties

@Stable
sealed interface RadioButtonState : BasicRadioButtonProperties {
    data object Selected : RadioButtonState
    data object Unselected : RadioButtonState
}