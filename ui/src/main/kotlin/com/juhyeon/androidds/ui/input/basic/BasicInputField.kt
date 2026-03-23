package com.juhyeon.androidds.ui.input.basic

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juhyeon.androidds.extension.clickableSingleIgnoreInteraction
import com.juhyeon.androidds.ui.button.basic.ButtonClickType
import com.juhyeon.androidds.ui.button.basic.ButtonState
import com.juhyeon.androidds.ui.button.icon.BasicIconButton
import com.juhyeon.androidds.ui.icon.BasicIcons
import com.juhyeon.androidds.ui.icon.basic.BasicIconSize
import com.juhyeon.androidds.ui.theme.BasicMaterialTheme
import com.juhyeon.androidds.ui.theme.Radius8
import com.juhyeon.androidds.ui.theme.medium

@Composable
fun BasicInputField(
    state: InputFieldState = InputFieldState.Enabled,
    type: InputFieldType = InputFieldType.Normal,
    placeholder: InputFieldPlaceholder = InputFieldPlaceholder.False,
    enabled: InputFieldEnabled = InputFieldEnabled.Enabled,
    focusRequester: FocusRequester = FocusRequester(),
    value: String,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit,
    onFocusChanged: (FocusState) -> Unit = { },
    onClick: () -> Unit = { }
) {
    val (textColor, backgroundColor, borderColor) = when (enabled) {
        InputFieldEnabled.Enabled -> {
            when (state) {
                is InputFieldState.Enabled -> {
                    Triple(
                        BasicMaterialTheme.colors.labelNormal,
                        BasicMaterialTheme.colors.backgroundNormal,
                        BasicMaterialTheme.colors.lineNormal
                    )
                }
                is InputFieldState.Active -> {
                    Triple(
                        BasicMaterialTheme.colors.labelNormal,
                        BasicMaterialTheme.colors.backgroundNormal,
                        BasicMaterialTheme.colors.labelAlternative
                    )
                }
                is InputFieldState.Done -> {
                    Triple(
                        BasicMaterialTheme.colors.labelNormal,
                        BasicMaterialTheme.colors.backgroundNormal,
                        BasicMaterialTheme.colors.lineNormal
                    )
                }
                is InputFieldState.Error -> Triple(
                    BasicMaterialTheme.colors.statusNegative,
                    BasicMaterialTheme.colors.backgroundNormal,
                    BasicMaterialTheme.colors.statusNegative
                )
            }
        }
        InputFieldEnabled.Disabled ->
            Triple(
                BasicMaterialTheme.colors.labelAssistive,
                BasicMaterialTheme.colors.labelDisable,
                BasicMaterialTheme.colors.lineNormal
            )
    }
    BasicTextField(
        modifier = Modifier
            .onFocusChanged { onFocusChanged(it) }
            .focusRequester(focusRequester)
            .clip(Radius8)
            .border(1.dp, borderColor, Radius8)
            .background(backgroundColor),
        value = value,
        enabled = enabled is InputFieldEnabled.Enabled,
        readOnly = enabled is InputFieldEnabled.Disabled,
        maxLines = maxLines,
        singleLine = maxLines == 1,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        textStyle = MaterialTheme.typography.medium(14, 20).copy(color = textColor),
        onValueChange = onValueChange,
        cursorBrush = SolidColor(BasicMaterialTheme.colors.labelNormal),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp,
                        vertical = if (type is InputFieldType.Icon) 8.dp else 14.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                when (placeholder) {
                    is InputFieldPlaceholder.True -> {
                        if (value.isEmpty() && state == InputFieldState.Enabled) {
                            Text(
                                text = placeholder.text,
                                style = MaterialTheme.typography.medium(14, 20),
                                color = BasicMaterialTheme.colors.labelAssistive
                            )
                        }
                    }
                    InputFieldPlaceholder.False -> { }
                }
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    innerTextField()
                }

                when (type) {
                    is InputFieldType.Normal -> { }
                    is InputFieldType.Icon -> {
                        BasicIconButton(
                            iconSize = BasicIconSize.Medium,
                            drawableRes = type.icon,
                            tint = type.tint,
                            state = ButtonState.Disabled,
                            buttonClickType = ButtonClickType.Single,
                            onClick = onClick
                        )
                    }
                    is InputFieldType.Text -> {
                        Text(
                            modifier = Modifier.clickableSingleIgnoreInteraction { onClick() },
                            text = type.text,
                            style = MaterialTheme.typography.medium(14, 20),
                            color = BasicMaterialTheme.colors.labelNormal,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun BasicInputFieldPreview() {
    val text = remember { mutableStateOf("") }
    val focus = remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        BasicInputField(
            value = text.value,
            enabled = InputFieldEnabled.Enabled,
            state = when {
                focus.value -> InputFieldState.Active
                text.value.isEmpty() -> InputFieldState.Enabled
                else -> InputFieldState.Done
            },
            placeholder = InputFieldPlaceholder.True("placeholder"),
            onValueChange = { text.value = it },
            onFocusChanged = { focus.value = it.isFocused }
        )
        BasicInputField(
            value = text.value,
            enabled = InputFieldEnabled.Enabled,
            state = InputFieldState.Active,
            placeholder = InputFieldPlaceholder.True("placeholder"),
            onValueChange = { text.value = it }
        )
        BasicInputField(
            value = text.value,
            enabled = InputFieldEnabled.Enabled,
            state = InputFieldState.Done,
            placeholder = InputFieldPlaceholder.True("placeholder"),
            onValueChange = { text.value = it }
        )
        BasicInputField(
            value = text.value,
            enabled = InputFieldEnabled.Enabled,
            state = InputFieldState.Error,
            placeholder = InputFieldPlaceholder.True("placeholder"),
            onValueChange = { text.value = it }
        )

        BasicInputField(
            value = text.value,
            enabled = InputFieldEnabled.Disabled,
            state = InputFieldState.Enabled,
            placeholder = InputFieldPlaceholder.True("placeholder"),
            onValueChange = { text.value = it }
        )

        BasicInputField(
            value = text.value,
            enabled = InputFieldEnabled.Enabled,
            state = InputFieldState.Done,
            type = InputFieldType.Icon(icon = BasicIcons.Call),
            placeholder = InputFieldPlaceholder.True("placeholder"),
            onValueChange = { text.value = it }
        )
        BasicInputField(
            value = text.value,
            enabled = InputFieldEnabled.Enabled,
            state = InputFieldState.Done,
            type = InputFieldType.Text(text = "Text"),
            placeholder = InputFieldPlaceholder.True("placeholder"),
            onValueChange = { text.value = it }
        )
    }
}