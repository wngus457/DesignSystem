package com.juhyeon.androidds.ui.button.icon

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juhyeon.androidds.extension.clickableIgnoreInteraction
import com.juhyeon.androidds.extension.clickableSingle
import com.juhyeon.androidds.extension.clickableSingleIgnoreInteraction
import com.juhyeon.androidds.ui.button.basic.ButtonClickType
import com.juhyeon.androidds.ui.button.basic.ButtonState
import com.juhyeon.androidds.ui.icon.BasicIcons
import com.juhyeon.androidds.ui.icon.basic.BasicIcon
import com.juhyeon.androidds.ui.icon.basic.BasicIconSize
import com.juhyeon.androidds.ui.theme.BasicMaterialTheme

@Composable
fun BasicIconButton(
    modifier: Modifier = Modifier,
    @DrawableRes drawableRes: Int,
    iconSize: BasicIconSize,
    tint: Color = BasicMaterialTheme.colors.labelNormal,
    buttonClickType: ButtonClickType = ButtonClickType.Single,
    state: ButtonState = ButtonState.Enabled,
    contentDescription: String? = null,
    onClick: () -> Unit = { }
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .then(
                when (buttonClickType) {
                    ButtonClickType.NormalInteraction -> Modifier.clickable(enabled = state is ButtonState.Enabled) { onClick() }
                    ButtonClickType.Normal -> Modifier.clickableIgnoreInteraction(enabled = state is ButtonState.Enabled) { onClick() }
                    ButtonClickType.SingleInteraction -> Modifier.clickableSingle(enabled = state is ButtonState.Enabled) { onClick() }
                    ButtonClickType.Single -> Modifier.clickableSingleIgnoreInteraction(enabled = state is ButtonState.Enabled) { onClick() }
                }
            )
            .padding(2.dp)
    ) {
        BasicIcon(
            drawableRes = drawableRes,
            iconSize = iconSize,
            tint = tint,
            disabled = state is ButtonState.Disabled,
            contentDescription = contentDescription
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicIconButtonPreview() {
    BasicIconButton(
        drawableRes = BasicIcons.Error,
        iconSize = BasicIconSize.Small,
        onClick = { }
    )
}