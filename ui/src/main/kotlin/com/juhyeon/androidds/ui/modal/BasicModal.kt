package com.juhyeon.androidds.ui.modal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.juhyeon.androidds.extension.clickableSingle
import com.juhyeon.androidds.ui.theme.BasicMaterialTheme
import com.juhyeon.androidds.ui.theme.Palette
import com.juhyeon.androidds.ui.theme.medium
import com.juhyeon.androidds.ui.theme.semiBold

@Composable
fun BasicModal(
    isShow: Boolean,
    title: ModalTitle = ModalTitle.Off,
    content: @Composable () -> Unit,
    buttons: ModalButtons = ModalButtons.One("확인"),
    dismissOnClickOutside: Boolean = false,
    dismissOnBackPress: Boolean = false,
    onRightButtonClick: () -> Unit = { },
    onLeftButtonClick: () -> Unit = { },
    onDismiss: () -> Unit = { }
) {
    if (isShow) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(
                dismissOnBackPress = dismissOnBackPress,
                dismissOnClickOutside = dismissOnClickOutside
            )
        ) {
            AlertDialogContent(
                title = title,
                buttons = buttons,
                content = content,
                onRightButtonClick = onRightButtonClick,
                onLeftButtonClick = onLeftButtonClick
            )
        }
    }
}

@Composable
private fun AlertDialogContent(
    title: ModalTitle,
    buttons: ModalButtons,
    content: @Composable () -> Unit,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = Palette.Common100,
    onRightButtonClick: () -> Unit = { },
    onLeftButtonClick: () -> Unit = { }
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = shape,
        color = backgroundColor
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 40.dp, end = 16.dp, bottom = 24.dp)
            ) {
                if (title is ModalTitle.On) {
                    BasicModalTitle(title = title.title)
                    Spacer(modifier = Modifier.height(16.dp))
                }
                content()
            }
            when (buttons) {
                is ModalButtons.Off -> Spacer(modifier = Modifier.height(16.dp))
                is ModalButtons.One -> {
                    ModalButtonContent(
                        content = {
                            ModalButton(
                                text = buttons.text,
                                onClick = onRightButtonClick
                            )
                        }
                    )
                }
                is ModalButtons.Two -> {
                    ModalButtonContent(
                        content = {
                            ModalButton(
                                text = buttons.leftText,
                                color = Palette.Neutral5,
                                onClick = onLeftButtonClick
                            )
                            ModalButton(
                                text = buttons.rightText,
                                onClick = onRightButtonClick
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun BasicModalTitle(title: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = title,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.semiBold(18),
        color = Palette.Common0
    )
}

@Composable
private fun ModalButtonContent(
    content: @Composable RowScope.() -> Unit
) {
    HorizontalDivider(color = Palette.Neutral85)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
    ) {
        content()
    }
}

@Composable
private fun RowScope.ModalButton(
    text: String,
    color: Color = BasicMaterialTheme.colors.primaryNormal,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .weight(1f)
            .height(52.dp)
            .clickableSingle { onClick() },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            color = color,
            style = MaterialTheme.typography.medium(16)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicModalButtonTwoPreview() {
    Column {
        BasicModal(
            isShow = true,
            title = ModalTitle.On("테스트 Modal"),
            content = {
                Text("테스트 content")
            },
            buttons = ModalButtons.Two(
                leftText = "닫기",
                rightText = "확인"
            ),
            onLeftButtonClick = { },
            onRightButtonClick = { },
            onDismiss = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicModalButtonOnePreview() {
    BasicModal(
        isShow = true,
        title = ModalTitle.On("테스트 Modal"),
        content = {
            Text("테스트 content")
        },
        buttons = ModalButtons.One(
            text = "닫기"
        ),
        onLeftButtonClick = { },
        onRightButtonClick = { },
        onDismiss = { }
    )
}