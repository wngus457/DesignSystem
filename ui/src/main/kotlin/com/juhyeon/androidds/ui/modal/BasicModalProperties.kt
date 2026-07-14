package com.juhyeon.androidds.ui.modal

import androidx.compose.runtime.Stable

sealed interface BasicModalProperties

@Stable
sealed interface ModalTitle : BasicModalProperties {
    data class On(val title: String) : ModalTitle
    data object Off : ModalTitle
}

@Stable
sealed interface ModalButtons : BasicModalProperties {
    data class One(val text: String) : ModalButtons
    data class Two(val leftText: String, val rightText: String) : ModalButtons
    data object Off : ModalButtons
}