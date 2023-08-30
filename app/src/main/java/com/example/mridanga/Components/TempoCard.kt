package com.example.mridanga.Components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlin.reflect.KProperty

@Composable
fun TempoCardComponent(){
    Row(modifier = Modifier.padding(top = 20.dp, start = 35.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(modifier = Modifier.size(60.dp),
            onDraw = {
                drawCircle(color = Color.Gray)
            } )
        
        Spacer(modifier = Modifier.width(20.dp))

        Canvas(modifier = Modifier.size(130.dp),
            onDraw = {
                drawCircle(color = Color.Gray)
            } )

        Spacer(modifier = Modifier.width(20.dp))

        Canvas(modifier = Modifier.size(60.dp),
            onDraw = {
                drawCircle(color = Color.Gray)
            } )
    }

    Slider()
}

@SuppressLint("RememberReturnType")
@Composable
fun Slider() {
    var sliderPosition by remember { mutableStateOf(0f) }
        Slider(value = sliderPosition,
            onValueChange = { sliderPosition = it },
            modifier = Modifier.padding(start = 45.dp, end = 45.dp),
            colors = SliderDefaults.colors(
                thumbColor = Color.Black,
                activeTrackColor = Color.Black,
                inactiveTickColor = Color.Gray
            )
        )
    }

