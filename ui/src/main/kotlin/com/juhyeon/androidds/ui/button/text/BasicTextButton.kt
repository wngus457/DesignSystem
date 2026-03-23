package com.juhyeon.androidds.ui.button.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.juhyeon.androidds.ui.theme.Palette
import com.juhyeon.androidds.ui.theme.Radius6
import com.juhyeon.androidds.ui.theme.normal

@Composable
fun BasicTextButton(
    modifier: Modifier = Modifier,
    text: String,
    size: TextButtonSize,
    enabled: TextButtonEnabled,
    icon: TextButtonIcon,
    backgroundColor: Color = BasicMaterialTheme.colors.backgroundNormal,
    textColor: Color = if (enabled is TextButtonEnabled.Disabled) BasicMaterialTheme.colors.labelDisable else BasicMaterialTheme.colors.labelNormal,
    onClick: () -> Unit = { }
) {
    Row(
        modifier = modifier
            .clip(Radius6)
            .background(backgroundColor)
            .clickableSingle(enabled = enabled is TextButtonEnabled.Enabled) { onClick() }
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon is TextButtonIcon.Left) {
            BasicIcon(
                drawableRes = icon.icon,
                tint = icon.tint,
                iconSize = BasicIconSize.Small
            )
        }

        Text(
            text = text,
            color = textColor,
            style = when (size) {
                TextButtonSize.Small -> MaterialTheme.typography.normal(14, 20)
                TextButtonSize.Large -> MaterialTheme.typography.normal(16, 24)
            }
        )

        if (icon is TextButtonIcon.Right) {
            BasicIcon(
                drawableRes = icon.icon,
                tint = icon.tint,
                iconSize = BasicIconSize.Small
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicTextButtonPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        BasicTextButton(
            text = "small enabled",
            size = TextButtonSize.Small,
            enabled = TextButtonEnabled.Enabled,
            icon = TextButtonIcon.False,
            backgroundColor = Palette.Neutral70
        )
        BasicTextButton(
            text = "small disabled",
            size = TextButtonSize.Small,
            enabled = TextButtonEnabled.Disabled,
            icon = TextButtonIcon.False,
            backgroundColor = Palette.Neutral70
        )
        BasicTextButton(
            text = "large enabled",
            size = TextButtonSize.Large,
            enabled = TextButtonEnabled.Enabled,
            icon = TextButtonIcon.False,
            backgroundColor = Palette.Neutral70
        )
        BasicTextButton(
            text = "small left",
            size = TextButtonSize.Small,
            enabled = TextButtonEnabled.Enabled,
            icon = TextButtonIcon.Left(icon = BasicIcons.ArrowLeftLarge),
            backgroundColor = Palette.Neutral70
        )
        BasicTextButton(
            text = "small right",
            size = TextButtonSize.Small,
            enabled = TextButtonEnabled.Enabled,
            icon = TextButtonIcon.Right(icon = BasicIcons.ArrowLeftLarge),
            backgroundColor = Palette.Neutral70
        )
    }
}