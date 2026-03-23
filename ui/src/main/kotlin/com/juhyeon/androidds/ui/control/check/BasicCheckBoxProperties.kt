package com.juhyeon.androidds.ui.control.check

import androidx.compose.runtime.Stable

sealed interface BasicCheckBoxProperties

@Stable
sealed interface CheckBoxSize : BasicCheckBoxProperties {
    data object Small : CheckBoxSize
    data object Large : CheckBoxSize
}

@Stable
sealed interface CheckBoxState : BasicCheckBoxProperties {
    data object Checked : CheckBoxState
    data object Unchecked : CheckBoxState
}

@Stable
sealed interface CheckBoxEnabled : BasicCheckBoxProperties {
    data object Enabled : CheckBoxEnabled
    data object Disabled : CheckBoxEnabled
}