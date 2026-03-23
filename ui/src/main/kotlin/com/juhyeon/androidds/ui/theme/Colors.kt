package com.juhyeon.androidds.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

object Palette {
    val Common0 = Color(0xFF000000)
    val Common100 = Color(0xFFFFFFFF)

    val Neutral0 = Color(0xFF000000)
    val Neutral5 = Color(0xFF222222)
    val Neutral10 = Color(0xFF2D2D2D)
    val Neutral15 = Color(0xFF3A3A3A)
    val Neutral20 = Color(0xFF4A4A4A)
    val Neutral25 = Color(0xFF555555)
    val Neutral30 = Color(0xFF626262)
    val Neutral35 = Color(0xFF6D6D6D)
    val Neutral40 = Color(0xFF7A7A7A)
    val Neutral45 = Color(0xFF888888)
    val Neutral50 = Color(0xFF959595)
    val Neutral55 = Color(0xFFA2A2A2)
    val Neutral60 = Color(0xFFAFAFAF)
    val Neutral65 = Color(0xFFBABABA)
    val Neutral70 = Color(0xFFC8C8C8)
    val Neutral75 = Color(0xFFE2E2E2)
    val Neutral80 = Color(0xFFEDEDED)
    val Neutral85 = Color(0xFFF6F6F6)
    val Neutral90 = Color(0xFFFBFBFB)
    val Neutral100 = Color(0xFFFFFFFF)

    val ChorocGreen10 = Color(0xFF41661C)
    val ChorocGreen20 = Color(0xFF4B7620)
    val ChorocGreen30 = Color(0xFF6BA82E)
    val ChorocGreen40 = Color(0xFF84B752)
    val ChorocGreen50 = Color(0xFFA9CD86)
    val ChorocGreen60 = Color(0xFFC2DBA9)
    val ChorocGreen70 = Color(0xFFF0F6EA)

    val Lime10 = Color(0xFF767B00)
    val Lime20 = Color(0xFF888D00)
    val Lime30 = Color(0xFFC2CA00)
    val Lime40 = Color(0xFFCCD32B)
    val Lime50 = Color(0xFFDCE06B)
    val Lime60 = Color(0xFFE6E996)
    val Lime70 = Color(0xFFF9FAE6)

    val Red10 = Color(0xFF95271B)
    val Red20 = Color(0xFFAB2D1F)
    val Red30 = Color(0xFFF4402C)
    val Red40 = Color(0xFFF66050)
    val Red50 = Color(0xFFF99085)
    val Red60 = Color(0xFFFAB1A8)
    val Red70 = Color(0xFFFEECEA)

    val JYGRed10 = Color(0xFF831525)
    val JYGRed20 = Color(0xFF97182A)
    val JYGRed30 = Color(0xFFD7223C)
    val JYGRed40 = Color(0xFFDE485D)
    val JYGRed50 = Color(0xFFE87F8E)
    val JYGRed60 = Color(0xFFEFA4AF)
    val JYGRed70 = Color(0xFFFBE9EC)

    val Green10 = Color(0xFF007527)
    val Green20 = Color(0xFF00862D)
    val Green30 = Color(0xFF00BF40)
    val Green40 = Color(0xFF2BCA60)
    val Green50 = Color(0xFF6BDA90)
    val Green60 = Color(0xFF96E5B1)
    val Green70 = Color(0xFFE6F9EC)

    val Orange10 = Color(0xFF9C5900)
    val Orange20 = Color(0xFFB36600)
    val Orange30 = Color(0xFFFF9200)
    val Orange40 = Color(0xFFFFA52B)
    val Orange50 = Color(0xFFFFC06B)
    val Orange60 = Color(0xFFFFD296)
    val Orange70 = Color(0xFFFFF4E6)

    val Mint10 = Color(0xFF04707A)
    val Mint20 = Color(0xFF04818C)
    val Mint30 = Color(0xFF06B8C8)
    val Mint40 = Color(0xFF30C4D1)
    val Mint50 = Color(0xFF6FD6DF)
    val Mint60 = Color(0xFF99E2E8)
    val Mint70 = Color(0xFFE6F8FA)
}

@Immutable
class BasicColorScheme(
    val primaryNormal: Color,
    val primaryStrong: Color,
    val primaryHeavy: Color,
    val labelNormal: Color,
    val labelStrong: Color,
    val labelNeutral: Color,
    val labelAlternative: Color,
    val labelAssistive: Color,
    val labelDisable: Color,
    val backgroundNormal: Color,
    val backgroundAlternative: Color,
    val lineNormal: Color,
    val lineNeutral: Color,
    val lineAlternative: Color,
    val lineStrong: Color,
    val fillNormal: Color,
    val fillStrong: Color,
    val fillAlternative: Color,
    val statusPositive: Color,
    val statusCautionary: Color,
    val statusNegative: Color,
    val accentLime: Color,
    val accentRed: Color,
    val accentGreen: Color,
    val accentOrange: Color,
    val accentMint: Color,
    val materialDimmer: Color,
    val staticBlack: Color,
    val staticWhite: Color,
    val inverseFill: Color
)

fun darkColorScheme(
    primaryNormal: Color = Palette.Common0,
    primaryStrong: Color = Palette.Neutral25,
    primaryHeavy: Color = Palette.Neutral40,
    labelNormal: Color = Palette.Neutral10,
    labelStrong: Color = Palette.Neutral0,
    labelNeutral: Color = Palette.Neutral25,
    labelAlternative: Color = Palette.Neutral40,
    labelAssistive: Color = Palette.Neutral70,
    labelDisable: Color = Palette.Neutral80,
    backgroundNormal: Color = Palette.Common100,
    backgroundAlternative: Color = Palette.Neutral85,
    lineNormal: Color = Color(0xFF555555).copy(Opacity16),
    lineNeutral: Color = Color(0xFF555555).copy(Opacity8),
    lineAlternative: Color = Color(0xFF555555).copy(Opacity4),
    lineStrong: Color = Color(0xFF555555).copy(Opacity40),
    fillNormal: Color = Color(0xFF555555).copy(Opacity8),
    fillStrong: Color = Color(0xFF555555).copy(Opacity16),
    fillAlternative: Color = Color(0xFF555555).copy(Opacity4),
    statusPositive: Color = Palette.Green30,
    statusCautionary: Color = Palette.Orange30,
    statusNegative: Color = Palette.Red30,
    accentLime: Color = Palette.Lime30,
    accentRed: Color = Palette.Red30,
    accentGreen: Color = Palette.Green30,
    accentOrange: Color = Palette.Orange30,
    accentMint: Color = Palette.Mint30,
    materialDimmer: Color = Color(0xFF000000).copy(Opacity44),
    staticBlack: Color = Palette.Common0,
    staticWhite: Color = Palette.Common100,
    inverseFill: Color = Palette.Neutral5
): BasicColorScheme =
    BasicColorScheme(
        primaryNormal = primaryNormal,
        primaryStrong = primaryStrong,
        primaryHeavy = primaryHeavy,
        labelNormal = labelNormal,
        labelStrong = labelStrong,
        labelNeutral = labelNeutral,
        labelAlternative = labelAlternative,
        labelAssistive = labelAssistive,
        labelDisable = labelDisable,
        backgroundNormal = backgroundNormal,
        backgroundAlternative = backgroundAlternative,
        lineNormal = lineNormal,
        lineNeutral = lineNeutral,
        lineAlternative = lineAlternative,
        lineStrong = lineStrong,
        fillNormal = fillNormal,
        fillStrong = fillStrong,
        fillAlternative = fillAlternative,
        statusPositive = statusPositive,
        statusCautionary = statusCautionary,
        statusNegative = statusNegative,
        accentLime = accentLime,
        accentRed = accentRed,
        accentGreen = accentGreen,
        accentOrange = accentOrange,
        accentMint = accentMint,
        materialDimmer = materialDimmer,
        staticBlack = staticBlack,
        staticWhite = staticWhite,
        inverseFill = inverseFill

    )

fun lightColorScheme(
    primaryNormal: Color = Palette.ChorocGreen30,
    primaryStrong: Color = Palette.ChorocGreen20,
    primaryHeavy: Color = Palette.ChorocGreen10,
    labelNormal: Color = Palette.Neutral10,
    labelStrong: Color = Palette.Neutral0,
    labelNeutral: Color = Palette.Neutral25,
    labelAlternative: Color = Palette.Neutral40,
    labelAssistive: Color = Palette.Neutral70,
    labelDisable: Color = Palette.Neutral80,
    backgroundNormal: Color = Palette.Common100,
    backgroundAlternative: Color = Palette.Neutral85,
    lineNormal: Color = Color(0xFF555555).copy(Opacity16),
    lineNeutral: Color = Color(0xFF555555).copy(Opacity8),
    lineAlternative: Color = Color(0xFF555555).copy(Opacity4),
    lineStrong: Color = Color(0xFF555555).copy(Opacity40),
    fillNormal: Color = Color(0xFF555555).copy(Opacity8),
    fillStrong: Color = Color(0xFF555555).copy(Opacity16),
    fillAlternative: Color = Color(0xFF555555).copy(Opacity4),
    statusPositive: Color = Palette.Green30,
    statusCautionary: Color = Palette.Orange30,
    statusNegative: Color = Palette.Red30,
    accentLime: Color = Palette.Lime30,
    accentRed: Color = Palette.Red30,
    accentGreen: Color = Palette.Green30,
    accentOrange: Color = Palette.Orange30,
    accentMint: Color = Palette.Mint30,
    materialDimmer: Color = Color(0xFF000000).copy(Opacity44),
    staticBlack: Color = Palette.Common0,
    staticWhite: Color = Palette.Common100,
    inverseFill: Color = Palette.Neutral5
): BasicColorScheme =
    BasicColorScheme(
        primaryNormal = primaryNormal,
        primaryStrong = primaryStrong,
        primaryHeavy = primaryHeavy,
        labelNormal = labelNormal,
        labelStrong = labelStrong,
        labelNeutral = labelNeutral,
        labelAlternative = labelAlternative,
        labelAssistive = labelAssistive,
        labelDisable = labelDisable,
        backgroundNormal = backgroundNormal,
        backgroundAlternative = backgroundAlternative,
        lineNormal = lineNormal,
        lineNeutral = lineNeutral,
        lineAlternative = lineAlternative,
        lineStrong = lineStrong,
        fillNormal = fillNormal,
        fillStrong = fillStrong,
        fillAlternative = fillAlternative,
        statusPositive = statusPositive,
        statusCautionary = statusCautionary,
        statusNegative = statusNegative,
        accentLime = accentLime,
        accentRed = accentRed,
        accentGreen = accentGreen,
        accentOrange = accentOrange,
        accentMint = accentMint,
        materialDimmer = materialDimmer,
        staticBlack = staticBlack,
        staticWhite = staticWhite,
        inverseFill = inverseFill
    )