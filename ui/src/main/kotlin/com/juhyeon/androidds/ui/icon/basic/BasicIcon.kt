package com.juhyeon.androidds.ui.icon.basic

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.juhyeon.androidds.ui.theme.BasicMaterialTheme

@Composable
fun BasicIcon(
    modifier: Modifier = Modifier,
    @DrawableRes drawableRes: Int,
    iconSize: BasicIconSize,
    tint: Color = BasicMaterialTheme.colors.labelNormal,
    disabled: Boolean = false,
    contentDescription: String? = null
) {
    val size = when (iconSize) {
        BasicIconSize.Tiny -> 16.dp
        BasicIconSize.Small -> 20.dp
        BasicIconSize.Regular -> 24.dp
        BasicIconSize.Medium -> 28.dp
        BasicIconSize.Large -> 32.dp
    }

    Icon(
        modifier = Modifier
            .size(size)
            .then(modifier),
        painter = painterResource(drawableRes),
        tint = if (disabled) BasicMaterialTheme.colors.labelDisable else tint,
        contentDescription = contentDescription
    )
}