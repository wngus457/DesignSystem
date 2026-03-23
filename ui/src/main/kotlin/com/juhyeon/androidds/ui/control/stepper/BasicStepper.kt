package com.juhyeon.androidds.ui.control.stepper

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juhyeon.androidds.ui.button.basic.ButtonClickType
import com.juhyeon.androidds.ui.button.basic.ButtonState
import com.juhyeon.androidds.ui.button.icon.BasicIconButton
import com.juhyeon.androidds.ui.icon.BasicIcons
import com.juhyeon.androidds.ui.icon.basic.BasicIconSize
import com.juhyeon.androidds.ui.theme.BasicMaterialTheme
import com.juhyeon.androidds.ui.theme.Palette
import com.juhyeon.androidds.ui.theme.Radius8
import com.juhyeon.androidds.ui.theme.normal

@Composable
fun BasicStepper(
    modifier: Modifier = Modifier,
    state: StepperState = StepperState.Both,
    stepperSize: StepperSize = StepperSize.Small,
    buttonClickType: ButtonClickType = ButtonClickType.NormalInteraction,
    count: Int = 0,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit
) {
    val (buttonSize, textStyle) = when (stepperSize) {
        StepperSize.Small -> BasicIconSize.Small to MaterialTheme.typography.normal(16, 24)
        StepperSize.Large -> BasicIconSize.Medium to MaterialTheme.typography.normal(18, 26)
    }
    Row(
        modifier = modifier
            .background(Palette.Common100, Radius8)
            .border(BorderStroke(1.dp, BasicMaterialTheme.colors.lineNormal), Radius8)
            .clip(Radius8)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        BasicIconButton(
            drawableRes = BasicIcons.Remove,
            iconSize = buttonSize,
            tint = when (state) {
                StepperState.Disabled, StepperState.Minimum -> BasicMaterialTheme.colors.labelDisable
                else -> BasicMaterialTheme.colors.labelNormal
            },
            state = if (state is StepperState.Disabled || state is StepperState.Minimum) ButtonState.Disabled else ButtonState.Enabled,
            buttonClickType = buttonClickType,
            onClick = onMinusClick
        )

        Text(
            text = "$count",
            style = textStyle,
            color = BasicMaterialTheme.colors.labelNormal
        )

        BasicIconButton(
            drawableRes = BasicIcons.Add,
            iconSize = buttonSize,
            tint = when (state) {
                StepperState.Disabled, StepperState.Maximum -> BasicMaterialTheme.colors.labelDisable
                else -> BasicMaterialTheme.colors.labelNormal
            },
            state = if (state is StepperState.Disabled || state is StepperState.Maximum) ButtonState.Disabled else ButtonState.Enabled,
            buttonClickType = buttonClickType,
            onClick = onPlusClick
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicStepperPreview() {
    val count = remember { mutableIntStateOf(1) }
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        BasicStepper(
            stepperSize = StepperSize.Small,
            state = when {
                count.intValue - 1 <= 0 -> StepperState.Minimum
                count.intValue + 1 >= 10 -> StepperState.Maximum
                else -> StepperState.Both
            },
            count = count.intValue,
            onMinusClick = { count.intValue -= 1 },
            onPlusClick = { count.intValue += 1 }
        )
        BasicStepper(
            stepperSize = StepperSize.Large,
            state = when {
                count.intValue - 1 <= 0 -> StepperState.Minimum
                count.intValue + 1 >= 10 -> StepperState.Maximum
                else -> StepperState.Both
            },
            count = count.intValue,
            onMinusClick = { count.intValue -= 1 },
            onPlusClick = { count.intValue += 1 }
        )
    }
}