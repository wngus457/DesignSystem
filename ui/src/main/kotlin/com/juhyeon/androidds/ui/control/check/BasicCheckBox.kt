package com.juhyeon.androidds.ui.control.check

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juhyeon.androidds.extension.clickableSingle
import com.juhyeon.androidds.ui.icon.BasicIcons
import com.juhyeon.androidds.ui.icon.basic.BasicIcon
import com.juhyeon.androidds.ui.icon.basic.BasicIconSize
import com.juhyeon.androidds.ui.theme.BasicMaterialTheme
import com.juhyeon.androidds.ui.theme.Opacity48
import com.juhyeon.androidds.ui.theme.Radius4
import com.juhyeon.androidds.ui.theme.normal

@Composable
fun BasicCheckBox(
    modifier: Modifier = Modifier,
    state: CheckBoxState,
    size: CheckBoxSize,
    enabled: CheckBoxEnabled,
    onClick: () -> Unit = { }
) {
    val background = when (state) {
        CheckBoxState.Checked -> {
            when (enabled) {
                CheckBoxEnabled.Enabled -> Modifier.background(BasicMaterialTheme.colors.primaryNormal)
                CheckBoxEnabled.Disabled -> Modifier
                    .alpha(Opacity48)
                    .background(BasicMaterialTheme.colors.primaryNormal)
            }
        }
        CheckBoxState.Unchecked -> {
            when (enabled) {
                CheckBoxEnabled.Enabled -> Modifier
                    .border(1.dp, BasicMaterialTheme.colors.lineNormal, Radius4)
                    .background(BasicMaterialTheme.colors.staticWhite)
                CheckBoxEnabled.Disabled -> Modifier
                    .alpha(Opacity48)
                    .border(1.dp, BasicMaterialTheme.colors.lineNormal, Radius4)
                    .background(BasicMaterialTheme.colors.fillStrong)
            }
        }
    }
    Box(
        modifier = modifier
            .size(if (size is CheckBoxSize.Small) 18.dp else 20.dp)
            .clip(Radius4)
            .then(background)
            .clickableSingle(enabled = enabled is CheckBoxEnabled.Enabled) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (state is CheckBoxState.Checked) {
            BasicIcon(
                drawableRes = BasicIcons.Check,
                tint = BasicMaterialTheme.colors.staticWhite,
                iconSize = if (size is CheckBoxSize.Small) BasicIconSize.Tiny else BasicIconSize.Small
            )
        }
    }
}

@Composable
fun TextCheckBox(
    modifier: Modifier = Modifier,
    state: CheckBoxState,
    size: CheckBoxSize,
    enabled: CheckBoxEnabled,
    text: String,
    onClick: () -> Unit = { }
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        BasicCheckBox(
            state = state,
            size = size,
            enabled = enabled,
            onClick = onClick
        )
        Text(
            text = text,
            color = when (enabled) {
                CheckBoxEnabled.Enabled -> BasicMaterialTheme.colors.labelNormal
                CheckBoxEnabled.Disabled -> BasicMaterialTheme.colors.labelDisable
            },
            style = MaterialTheme.typography.normal(16, 24)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicCheckBoxPreview() {
    Column(
        modifier = Modifier.padding(2.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        BasicCheckBox(
            state = CheckBoxState.Checked,
            size = CheckBoxSize.Small,
            enabled = CheckBoxEnabled.Enabled
        )
        BasicCheckBox(
            state = CheckBoxState.Checked,
            size = CheckBoxSize.Large,
            enabled = CheckBoxEnabled.Enabled
        )
        BasicCheckBox(
            state = CheckBoxState.Unchecked,
            size = CheckBoxSize.Large,
            enabled = CheckBoxEnabled.Enabled
        )
        BasicCheckBox(
            state = CheckBoxState.Checked,
            size = CheckBoxSize.Large,
            enabled = CheckBoxEnabled.Disabled
        )
        BasicCheckBox(
            state = CheckBoxState.Unchecked,
            size = CheckBoxSize.Large,
            enabled = CheckBoxEnabled.Disabled
        )
        TextCheckBox(
            state = CheckBoxState.Checked,
            size = CheckBoxSize.Small,
            enabled = CheckBoxEnabled.Enabled,
            text = "Label"
        )

        TextCheckBox(
            state = CheckBoxState.Checked,
            size = CheckBoxSize.Large,
            enabled = CheckBoxEnabled.Enabled,
            text = "Label"
        )
        TextCheckBox(
            state = CheckBoxState.Unchecked,
            size = CheckBoxSize.Large,
            enabled = CheckBoxEnabled.Enabled,
            text = "Label"
        )
        TextCheckBox(
            state = CheckBoxState.Checked,
            size = CheckBoxSize.Large,
            enabled = CheckBoxEnabled.Disabled,
            text = "Label"
        )
        TextCheckBox(
            state = CheckBoxState.Unchecked,
            size = CheckBoxSize.Large,
            enabled = CheckBoxEnabled.Disabled,
            text = "Label"
        )
    }
}