package com.juhyeon.androidds.ui.button.basic

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juhyeon.androidds.extension.clickableIgnoreInteraction
import com.juhyeon.androidds.extension.clickableSingle
import com.juhyeon.androidds.extension.clickableSingleIgnoreInteraction
import com.juhyeon.androidds.ui.icon.BasicIcons
import com.juhyeon.androidds.ui.icon.basic.BasicIcon
import com.juhyeon.androidds.ui.theme.BasicMaterialTheme
import com.juhyeon.androidds.ui.theme.Radius8
import com.juhyeon.androidds.ui.theme.bold
import com.juhyeon.androidds.ui.theme.medium

@Composable
fun BasicButton(
    modifier: Modifier = Modifier,
    type: ButtonStyle,
    state: ButtonState = ButtonState.Enabled,
    buttonIcon: ButtonIcon = ButtonIcon.False,
    buttonSize: ButtonSize = ButtonSize.Small,
    buttonClickType: ButtonClickType = ButtonClickType.Single,
    text: String,
    onClick: () -> Unit
) {
    val (backgroundColor, textColor, outlined) = when (type) {
        ButtonStyle.Solid -> {
            when (state) {
                ButtonState.Enabled -> Triple(
                    BasicMaterialTheme.colors.primaryNormal,
                    BasicMaterialTheme.colors.staticWhite,
                    Modifier
                )
                ButtonState.Disabled -> Triple(
                    BasicMaterialTheme.colors.labelDisable,
                    BasicMaterialTheme.colors.labelAssistive,
                    Modifier
                )
            }
        }
        ButtonStyle.Outlined -> {
            when (state) {
                ButtonState.Enabled -> Triple(
                    BasicMaterialTheme.colors.staticWhite,
                    BasicMaterialTheme.colors.primaryNormal,
                    Modifier.border(1.dp, BasicMaterialTheme.colors.primaryNormal, Radius8)
                )
                ButtonState.Disabled -> Triple(
                    BasicMaterialTheme.colors.staticWhite,
                    BasicMaterialTheme.colors.labelAssistive,
                    Modifier.border(1.dp, BasicMaterialTheme.colors.lineNormal, Radius8)
                )
            }
        }
    }

    val (textStyle, verticalPadding) = when (buttonSize) {
        ButtonSize.Small -> MaterialTheme.typography.medium(14, 20) to 8.dp
        ButtonSize.Medium -> MaterialTheme.typography.medium(16, 24) to 10.dp
        ButtonSize.Large -> MaterialTheme.typography.bold(16, 24) to 14.dp
    }

    Box(
        modifier = modifier
            .clip(Radius8)
            .then(outlined)
            .background(backgroundColor)
            .then(
                when (buttonClickType) {
                    ButtonClickType.NormalInteraction -> Modifier.clickable(enabled = state is ButtonState.Enabled) { onClick() }
                    ButtonClickType.Normal -> Modifier.clickableIgnoreInteraction(enabled = state is ButtonState.Enabled) { onClick() }
                    ButtonClickType.SingleInteraction -> Modifier.clickableSingle(enabled = state is ButtonState.Enabled) { onClick() }
                    ButtonClickType.Single -> Modifier.clickableSingleIgnoreInteraction(enabled = state is ButtonState.Enabled) { onClick() }
                }
            )
            .padding(vertical = verticalPadding, horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                style = textStyle,
                color = textColor
            )
            if (buttonIcon is ButtonIcon.True) {
                BasicIcon(
                    drawableRes = buttonIcon.icon,
                    iconSize = buttonIcon.size,
                    tint = textColor
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicButtonPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BasicMaterialTheme.colors.backgroundNormal),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicButton(
            type = ButtonStyle.Solid,
            text = "solid small",
            onClick = { }
        )
        BasicButton(
            type = ButtonStyle.Solid,
            buttonSize = ButtonSize.Medium,
            text = "solid medium",
            onClick = { }
        )
        BasicButton(
            type = ButtonStyle.Solid,
            buttonSize = ButtonSize.Large,
            text = "solid large",
            onClick = { }
        )
        BasicButton(
            type = ButtonStyle.Solid,
            buttonSize = ButtonSize.Large,
            buttonIcon = ButtonIcon.True(icon = BasicIcons.ArrowRightLarge),
            text = "solid icon",
            onClick = { }
        )
        BasicButton(
            type = ButtonStyle.Solid,
            buttonSize = ButtonSize.Large,
            state = ButtonState.Disabled,
            text = "solid disabled",
            onClick = { }
        )
        BasicButton(
            type = ButtonStyle.Outlined,
            text = "outlined small",
            onClick = { }
        )
        BasicButton(
            type = ButtonStyle.Outlined,
            buttonSize = ButtonSize.Medium,
            text = "outlined medium",
            onClick = { }
        )
        BasicButton(
            type = ButtonStyle.Outlined,
            buttonSize = ButtonSize.Large,
            text = "outlined large",
            onClick = { }
        )
        BasicButton(
            type = ButtonStyle.Outlined,
            buttonSize = ButtonSize.Large,
            state = ButtonState.Disabled,
            text = "outlined disabled",
            onClick = { }
        )
        BasicButton(
            type = ButtonStyle.Outlined,
            buttonSize = ButtonSize.Large,
            buttonIcon = ButtonIcon.True(icon = BasicIcons.ArrowRightLarge),
            text = "outlined icon",
            onClick = { }
        )
    }
}