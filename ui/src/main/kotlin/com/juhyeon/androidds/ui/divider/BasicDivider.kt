package com.juhyeon.androidds.ui.divider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juhyeon.androidds.ui.theme.BasicMaterialTheme

@Composable
fun BasicDivider(
    modifier: Modifier = Modifier,
    axisType: DividerAxisType,
    thickness: DividerThickness = DividerThickness.Tiny,
    color: Color = BasicMaterialTheme.colors.lineNeutral
) {
    val thicknessDp = when (thickness) {
        DividerThickness.Tiny -> 1.dp
        DividerThickness.Small -> 4.dp
        DividerThickness.Regular -> 6.dp
        DividerThickness.Large -> 12.dp
    }
    when (axisType) {
        is DividerAxisType.Vertical -> {
            VerticalDivider(
                modifier = modifier
                    .then(
                        when (axisType.heightType) {
                            DividerHeightType.FillMaxHeight -> Modifier.fillMaxHeight()
                            is DividerHeightType.Height -> Modifier.height(axisType.heightType.height.dp)
                        }
                    ),
                thickness = thicknessDp,
                color = color
            )
        }
        is DividerAxisType.Horizontal ->
            HorizontalDivider(
                modifier = modifier,
                thickness = thicknessDp,
                color = color
            )
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicDividerPreview() {
    Column(
        modifier = Modifier.background(BasicMaterialTheme.colors.backgroundNormal),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicDivider(
            modifier = Modifier.padding(top = 20.dp),
            axisType = DividerAxisType.Horizontal,
            thickness = DividerThickness.Tiny
        )
        BasicDivider(
            axisType = DividerAxisType.Horizontal,
            thickness = DividerThickness.Small
        )
        BasicDivider(
            axisType = DividerAxisType.Horizontal,
            thickness = DividerThickness.Regular
        )
        BasicDivider(
            axisType = DividerAxisType.Horizontal,
            thickness = DividerThickness.Large
        )
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                BasicDivider(
                    axisType = DividerAxisType.Vertical(DividerHeightType.Height(10)),
                    thickness = DividerThickness.Tiny
                )
                BasicDivider(
                    axisType = DividerAxisType.Vertical(DividerHeightType.Height(10)),
                    thickness = DividerThickness.Small
                )
                BasicDivider(
                    axisType = DividerAxisType.Vertical(DividerHeightType.Height(10)),
                    thickness = DividerThickness.Regular
                )
                BasicDivider(
                    axisType = DividerAxisType.Vertical(DividerHeightType.Height(10)),
                    thickness = DividerThickness.Large
                )
            }
            BasicDivider(
                axisType = DividerAxisType.Vertical(DividerHeightType.FillMaxHeight),
                thickness = DividerThickness.Large
            )
        }
    }
}