package com.juhyeon.androidds.ui.tooltip

import androidx.compose.foundation.BasicTooltipBox
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberBasicTooltipState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupPositionProvider
import com.juhyeon.androidds.extension.clickableSingle
import com.juhyeon.androidds.extension.dropShadow
import com.juhyeon.androidds.ui.button.icon.BasicIconButton
import com.juhyeon.androidds.ui.icon.BasicIcons
import com.juhyeon.androidds.ui.icon.basic.BasicIcon
import com.juhyeon.androidds.ui.icon.basic.BasicIconSize
import com.juhyeon.androidds.ui.theme.BasicMaterialTheme
import com.juhyeon.androidds.ui.theme.Palette
import com.juhyeon.androidds.ui.theme.Radius4
import com.juhyeon.androidds.ui.theme.bold
import com.juhyeon.androidds.ui.theme.normal
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TooltipBasic(
    modifier: Modifier = Modifier,
    tooltipHeader: TooltipHeader = TooltipHeader.False,
    tooltipColor: TooltipColor = TooltipColor.White,
    tooltipPosition: TooltipPosition = TooltipPosition.BottomCenter,
    content: String = "",
    requesterView: @Composable (Modifier) -> Unit
) {
    val state = rememberBasicTooltipState()
    val scope = rememberCoroutineScope()
    val (backgroundColor, titleColor, contentColor) = when (tooltipColor) {
        TooltipColor.White -> {
            Triple(
                BasicMaterialTheme.colors.staticWhite,
                BasicMaterialTheme.colors.labelNormal,
                BasicMaterialTheme.colors.labelNeutral
            )
        }
        TooltipColor.Black -> Triple(
            BasicMaterialTheme.colors.labelNormal,
            Palette.Neutral100,
            BasicMaterialTheme.colors.staticWhite
        )
    }
    BasicTooltipBox(
        state = state,
        positionProvider = remember { TooltipPositionProvider(tooltipPosition) },
        tooltip = {
            Box(
                modifier = Modifier
                    .dropShadow(
                        shape = Radius4,
                        blur = 4.dp,
                        offsetY = 2.dp,
                        color = Palette.Neutral0.copy(0.14f)
                    )
                    .dropShadow(
                        shape = Radius4,
                        blur = 2.dp,
                        color = Palette.Neutral0.copy(0.12f)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .clip(Radius4)
                        .background(backgroundColor)
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Column {
                        if (tooltipHeader is TooltipHeader.True) {
                            Text(
                                text = tooltipHeader.title,
                                color = titleColor,
                                style = MaterialTheme.typography.bold(12, 18)
                            )
                        }
                        Text(
                            text = content,
                            color = contentColor,
                            style = MaterialTheme.typography.normal(12, 18)
                        )
                    }
                    BasicIconButton(
                        drawableRes = BasicIcons.Close,
                        iconSize = BasicIconSize.Tiny,
                        tint = contentColor,
                        onClick = { scope.launch { state.dismiss() } }
                    )
                }
            }
        },
        content = {
            requesterView(
                modifier.clickableSingle { scope.launch { state.show() } }
            )
        }
    )
}

internal class TooltipPositionProvider(private val position: TooltipPosition) : PopupPositionProvider {
    override fun calculatePosition(
        anchorBounds: IntRect,
        windowSize: IntSize,
        layoutDirection: LayoutDirection,
        popupContentSize: IntSize
    ): IntOffset {
        val x: Int
        val y: Int
        when (position) {
            TooltipPosition.TopCenter -> {
                x = anchorBounds.left + (anchorBounds.width / 2) - (popupContentSize.width / 2)
                y = anchorBounds.top - popupContentSize.height
            }
            TooltipPosition.TopStart -> {
                x = anchorBounds.left
                y = anchorBounds.top - popupContentSize.height
            }
            TooltipPosition.TopEnd -> {
                x = anchorBounds.right - popupContentSize.width
                y = anchorBounds.top - popupContentSize.height
            }
            TooltipPosition.BottomCenter -> {
                x = anchorBounds.left + (anchorBounds.width / 2) - (popupContentSize.width / 2)
                y = anchorBounds.bottom
            }
            TooltipPosition.BottomStart -> {
                x = anchorBounds.left
                y = anchorBounds.bottom
            }
            TooltipPosition.BottomEnd -> {
                x = anchorBounds.right - (popupContentSize.width)
                y = anchorBounds.bottom
            }
            TooltipPosition.StartCenter -> {
                x = anchorBounds.left - popupContentSize.width
                y = anchorBounds.top + (anchorBounds.height / 2) - (popupContentSize.height / 2)
            }
            TooltipPosition.EndCenter -> {
                x = anchorBounds.right
                y = anchorBounds.top + (anchorBounds.height / 2) - (popupContentSize.height / 2)
            }
        }
        return IntOffset(x, y)
    }
}

@Preview(showBackground = true)
@Composable
private fun TooltipBasicPreview() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row {
                Text("topCenter")
                TooltipBasic(
                    tooltipHeader = TooltipHeader.False,
                    content = "테스트 tooltip",
                    tooltipColor = TooltipColor.Black,
                    tooltipPosition = TooltipPosition.TopCenter,
                    requesterView = {
                        BasicIcon(
                            drawableRes = BasicIcons.Error,
                            iconSize = BasicIconSize.Small
                        )
                    }
                )
            }
            Row {
                Text("topStart")
                TooltipBasic(
                    tooltipHeader = TooltipHeader.False,
                    content = "테스트 tooltip",
                    tooltipColor = TooltipColor.Black,
                    tooltipPosition = TooltipPosition.TopStart,
                    requesterView = {
                        BasicIcon(
                            drawableRes = BasicIcons.Error,
                            iconSize = BasicIconSize.Small
                        )
                    }
                )
            }
            Row {
                Text("topEnd")
                TooltipBasic(
                    tooltipHeader = TooltipHeader.False,
                    content = "테스트 tooltip",
                    tooltipColor = TooltipColor.Black,
                    tooltipPosition = TooltipPosition.TopEnd,
                    requesterView = {
                        BasicIcon(
                            drawableRes = BasicIcons.Error,
                            iconSize = BasicIconSize.Small
                        )
                    }
                )
            }
            Row {
                Text("bottomCenter")
                TooltipBasic(
                    tooltipHeader = TooltipHeader.False,
                    content = "테스트 tooltip",
                    tooltipColor = TooltipColor.Black,
                    tooltipPosition = TooltipPosition.BottomCenter,
                    requesterView = {
                        BasicIcon(
                            drawableRes = BasicIcons.Error,
                            iconSize = BasicIconSize.Small
                        )
                    }
                )
            }
            Row {
                Text("bottomStart")
                TooltipBasic(
                    tooltipHeader = TooltipHeader.False,
                    content = "테스트 tooltip",
                    tooltipColor = TooltipColor.Black,
                    tooltipPosition = TooltipPosition.BottomStart,
                    requesterView = {
                        BasicIcon(
                            drawableRes = BasicIcons.Error,
                            iconSize = BasicIconSize.Small
                        )
                    }
                )
            }
            Row {
                Text("bottomEnd")
                TooltipBasic(
                    tooltipHeader = TooltipHeader.False,
                    content = "테스트 tooltip",
                    tooltipColor = TooltipColor.Black,
                    tooltipPosition = TooltipPosition.BottomEnd,
                    requesterView = {
                        BasicIcon(
                            drawableRes = BasicIcons.Error,
                            iconSize = BasicIconSize.Small
                        )
                    }
                )
            }
            Row {
                Text("startCenter")
                TooltipBasic(
                    tooltipHeader = TooltipHeader.False,
                    content = "테스트 tooltip",
                    tooltipColor = TooltipColor.Black,
                    tooltipPosition = TooltipPosition.StartCenter,
                    requesterView = {
                        BasicIcon(
                            drawableRes = BasicIcons.Error,
                            iconSize = BasicIconSize.Small
                        )
                    }
                )
            }
            Row {
                Text("endCenter")
                TooltipBasic(
                    tooltipHeader = TooltipHeader.False,
                    content = "테스트 tooltip",
                    tooltipColor = TooltipColor.White,
                    tooltipPosition = TooltipPosition.EndCenter,
                    requesterView = {
                        BasicIcon(
                            drawableRes = BasicIcons.Error,
                            iconSize = BasicIconSize.Small
                        )
                    }
                )
            }
        }
    }
}