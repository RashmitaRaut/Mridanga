package com.example.mridanga.Components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.foundation.Canvas





@Composable
fun SpeedDonut(
    percent1: Float,
    percent2: Float,
    strokeWidth: Dp =10.dp,
    color1: Color = Color.Blue,
    color2: Color = Color.Cyan
) {
    Canvas(
        modifier = Modifier.aspectRatio(1f),
        onDraw = {
            val canvasSize = size
            val radius = (canvasSize.minDimension - strokeWidth.toPx()) / 2 * 0.6
            val center = Offset(canvasSize.width / 2, canvasSize.height / 2)

            drawArc(
                color = color1,
                startAngle = -90f,
                sweepAngle = 360f * percent1,
                useCenter = false,
                topLeft = center - Offset(radius.toFloat(), radius.toFloat()),
                size = Size((radius * 2).toFloat(), (radius * 2).toFloat()), // Use Jetpack Compose's Size class
                style = Stroke(strokeWidth.toPx())
            )

            drawArc(
                color = color2,
                startAngle = -90f + 360f * percent1,
                sweepAngle = 360f * percent2,
                useCenter = false,
                topLeft = center - Offset(radius.toFloat(), radius.toFloat()),
                size = Size((radius * 2).toFloat(), (radius * 2).toFloat()), // Use Jetpack Compose's Size class
                style = Stroke(strokeWidth.toPx())
            )
        }
    )
}


