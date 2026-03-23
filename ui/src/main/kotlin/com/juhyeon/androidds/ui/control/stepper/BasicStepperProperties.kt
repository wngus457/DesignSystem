package com.juhyeon.androidds.ui.control.stepper

import androidx.compose.runtime.Stable

sealed interface BasicStepperProperties

@Stable
sealed interface StepperSize : BasicStepperProperties {
    data object Small : StepperSize
    data object Large : StepperSize
}

@Stable
sealed interface StepperState : BasicStepperProperties {
    data object Minimum : StepperState
    data object Both : StepperState
    data object Maximum : StepperState
    data object Disabled : StepperState
}