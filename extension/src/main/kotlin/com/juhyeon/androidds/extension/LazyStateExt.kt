package com.juhyeon.androidds.extension

import androidx.compose.foundation.gestures.stopScroll
import androidx.compose.foundation.lazy.LazyListState

suspend fun LazyListState.safetyAnimateScrollToTop() = run {
    this.stopScroll()

    if (!this.isScrollInProgress) {
        this.animateScrollToItem(0)
    }
}