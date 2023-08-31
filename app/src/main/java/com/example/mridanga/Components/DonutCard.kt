package com.example.mridanga.Components

import android.media.MediaPlayer
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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.mridanga.data.TempoState

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
                size = Size((radius * 2).toFloat(), (radius * 2).toFloat()),
                style = Stroke(strokeWidth.toPx())
            )

            drawArc(
                color = color2,
                startAngle = -90f + 360f * percent1,
                sweepAngle = 360f * percent2,
                useCenter = false,
                topLeft = center - Offset(radius.toFloat(), radius.toFloat()),
                size = Size((radius * 2).toFloat(), (radius * 2).toFloat()),
                style = Stroke(strokeWidth.toPx())
            )
        }
    )
}

@Composable
fun TempoButtonComponent(text: String = " ", tempoState: TempoState, mediaPlayer: MediaPlayer, tempoChange: Int){
    Button(onClick = {
        try {
            tempoState.tempo += tempoChange
            updateTempoAndPlaybackSpeed(tempoState.tempo, mediaPlayer)
        } catch (e: Exception) {
            // Handle the exception here, if necessary
            e.printStackTrace()
        }
    },
    colors = ButtonDefaults.buttonColors(Color.White),
    elevation = ButtonDefaults.buttonElevation(5.dp),
    ) {
    Text(text = text, color = Color.Black)
}
}


@Composable
fun MixerSliderComponent(onDismiss: () -> Unit){
    var sliderPosition by remember { mutableStateOf(0f) }
    androidx.compose.material3.Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        modifier = Modifier.padding(start = 45.dp, end = 45.dp),
        colors = SliderDefaults.colors(
            thumbColor = Color.Black,
            activeTrackColor = Color.Black,
            inactiveTickColor = Color.Gray
        )
    )


}



