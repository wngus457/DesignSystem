package com.juhyeon.androidds.ui.control.radio

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juhyeon.androidds.extension.clickableSingle
import com.juhyeon.androidds.ui.button.basic.ButtonState
import com.juhyeon.androidds.ui.theme.BasicMaterialTheme
import com.juhyeon.androidds.ui.theme.Opacity48
import com.juhyeon.androidds.ui.theme.normal

@Composable
fun BasicRadioButton(
    radioButtonState: RadioButtonState,
    buttonState: ButtonState = ButtonState.Enabled,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .clickableSingle(enabled = buttonState is ButtonState.Enabled) { onClick() }
            .padding(2.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(20.dp)
                .alpha(if (buttonState is ButtonState.Enabled) 1f else Opacity48)
                .then(
                    if (radioButtonState is RadioButtonState.Selected) Modifier.background(BasicMaterialTheme.colors.primaryNormal)
                    else Modifier
                        .border(width = 1.5.dp, color = BasicMaterialTheme.colors.lineNormal, shape = CircleShape)
                        .background(
                            if (buttonState is ButtonState.Enabled) BasicMaterialTheme.colors.staticWhite
                            else BasicMaterialTheme.colors.fillStrong
                        )
                ),
            contentAlignment = Alignment.Center
        ) {
            if (radioButtonState is RadioButtonState.Selected) {
                val color = BasicMaterialTheme.colors.staticWhite
                Canvas(
                    modifier = Modifier.size(8.dp),
                    onDraw = { drawCircle(color = color) }
                )
            }
        }
    }
}

@Composable
fun TextRadioButton(
    modifier: Modifier = Modifier,
    radioButtonState: RadioButtonState = RadioButtonState.Selected,
    buttonState: ButtonState = ButtonState.Enabled,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.normal(16, 24),
    onClick: () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicRadioButton(
            radioButtonState = radioButtonState,
            buttonState = buttonState,
            onClick = onClick
        )
        Text(
            text = text,
            style = textStyle,
            color = if (buttonState is ButtonState.Enabled) BasicMaterialTheme.colors.labelNormal else BasicMaterialTheme.colors.labelAssistive
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicRadioButtonPreview() {
    Column(modifier = Modifier.background(BasicMaterialTheme.colors.backgroundNormal)) {
        BasicRadioButton(
            radioButtonState = RadioButtonState.Selected,
            onClick = { }
        )
        BasicRadioButton(
            radioButtonState = RadioButtonState.Unselected,
            onClick = { }
        )
        BasicRadioButton(
            radioButtonState = RadioButtonState.Selected,
            buttonState = ButtonState.Disabled,
            onClick = { }
        )
        BasicRadioButton(
            radioButtonState = RadioButtonState.Unselected,
            buttonState = ButtonState.Disabled,
            onClick = { }
        )
        TextRadioButton(
            radioButtonState = RadioButtonState.Selected,
            text = "테스트",
            onClick = { }
        )
        TextRadioButton(
            radioButtonState = RadioButtonState.Unselected,
            text = "테스트",
            onClick = { }
        )
        TextRadioButton(
            radioButtonState = RadioButtonState.Selected,
            text = "테스트",
            buttonState = ButtonState.Disabled,
            onClick = { }
        )
        TextRadioButton(
            radioButtonState = RadioButtonState.Unselected,
            text = "테스트",
            buttonState = ButtonState.Disabled,
            onClick = { }
        )
    }
}