package com.juhyeon.androidds.extension

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.stopScroll

suspend fun ScrollState.safetyAnimateScrollToTop() = run {
    this.stopScroll()

    if (!this.isScrollInProgress) {
        this.animateScrollTo(0)
    }
}