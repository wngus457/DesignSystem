package com.juhyeon.androidds.ui.button.floating

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juhyeon.androidds.extension.clickableSingle
import com.juhyeon.androidds.ui.icon.BasicIcons
import com.juhyeon.androidds.ui.icon.basic.BasicIcon
import com.juhyeon.androidds.ui.icon.basic.BasicIconSize
import com.juhyeon.androidds.ui.theme.BasicMaterialTheme

@Composable
fun BasicFloatingButton(
    modifier: Modifier = Modifier,
    size: FloatingSize,
    style: FloatingStyle,
    state: FloatingState,
    @DrawableRes icon: Int,
    onClick: () -> Unit
) {
    val (iconSize, padding) = when (size) {
        FloatingSize.Regular -> BasicIconSize.Medium to 6.dp
        FloatingSize.Large -> BasicIconSize.Large to 9.dp
    }
    val (background, tint) = when (style) {
        FloatingStyle.Filled -> {
            when (state) {
                FloatingState.Enabled -> Modifier.background(Color(0xFF222C18).copy(0.4f)) to BasicMaterialTheme.colors.staticWhite
                FloatingState.Disabled -> Modifier.background(BasicMaterialTheme.colors.labelDisable) to BasicMaterialTheme.colors.labelAssistive
            }
        }
        FloatingStyle.Outlined -> {
            when (state) {
                FloatingState.Enabled -> Modifier.border(1.dp, BasicMaterialTheme.colors.lineNormal, CircleShape) to BasicMaterialTheme.colors.labelNormal
                FloatingState.Disabled -> Modifier.border(1.dp, BasicMaterialTheme.colors.lineNeutral, CircleShape) to BasicMaterialTheme.colors.labelDisable
            }
        }
    }
    Box(
        modifier = modifier
            .clip(CircleShape)
            .then(background)
            .clickableSingle(enabled = state is FloatingState.Enabled) { onClick() }
            .padding(padding)
    ) {
        BasicIcon(
            drawableRes = icon,
            iconSize = iconSize,
            tint = tint
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicFloatingButtonPreview() {
    Column {
        BasicFloatingButton(
            size = FloatingSize.Regular,
            style = FloatingStyle.Filled,
            state = FloatingState.Enabled,
            icon = BasicIcons.ShoppingBag,
            onClick = { }
        )
        BasicFloatingButton(
            size = FloatingSize.Regular,
            style = FloatingStyle.Filled,
            state = FloatingState.Disabled,
            icon = BasicIcons.ShoppingBag,
            onClick = { }
        )
        BasicFloatingButton(
            size = FloatingSize.Regular,
            style = FloatingStyle.Outlined,
            state = FloatingState.Enabled,
            icon = BasicIcons.ShoppingBag,
            onClick = { }
        )
        BasicFloatingButton(
            size = FloatingSize.Regular,
            style = FloatingStyle.Outlined,
            state = FloatingState.Disabled,
            icon = BasicIcons.ShoppingBag,
            onClick = { }
        )
        BasicFloatingButton(
            size = FloatingSize.Large,
            style = FloatingStyle.Filled,
            state = FloatingState.Enabled,
            icon = BasicIcons.ShoppingBag,
            onClick = { }
        )
        BasicFloatingButton(
            size = FloatingSize.Large,
            style = FloatingStyle.Filled,
            state = FloatingState.Disabled,
            icon = BasicIcons.ShoppingBag,
            onClick = { }
        )
        BasicFloatingButton(
            size = FloatingSize.Large,
            style = FloatingStyle.Outlined,
            state = FloatingState.Enabled,
            icon = BasicIcons.ShoppingBag,
            onClick = { }
        )
        BasicFloatingButton(
            size = FloatingSize.Large,
            style = FloatingStyle.Outlined,
            state = FloatingState.Disabled,
            icon = BasicIcons.ShoppingBag,
            onClick = { }
        )
    }
}