package com.example.mridanga.Components

import android.media.MediaPlayer
import android.media.PlaybackParams
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mridanga.data.TempoState

@Composable
fun TaalDropDownComponent() {

    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    Spacer(modifier = Modifier.width(10.dp))

    Box{
        Button(onClick = { expanded = !expanded },
            colors = ButtonDefaults.buttonColors(Color.White),
            elevation = ButtonDefaults.buttonElevation(8.dp)
        ) {
            Text(text = "Add Talam", color = Color.Black)
            Icon(imageVector = Icons.Default.ArrowDropDown,
                contentDescription = " DropDown",
                tint = Color.Black
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Adi") },
                onClick = { Toast.makeText(context, "Adi", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                text = { Text("Roopakam") },
                onClick = { Toast.makeText(context, "Roopakam", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                text = { Text("Khandam") },
                onClick = { Toast.makeText(context, "Khandam", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                text = { Text("Misram") },
                onClick = { Toast.makeText(context, "Misram", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                text = { Text("Sankeernam") },
                onClick = { Toast.makeText(context, "Sankeernam", Toast.LENGTH_SHORT).show() }
            )
        }
    }

    }


@Composable
fun PatternDropDownComponent() {

    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    Box{
        Button(onClick = { expanded = !expanded },
            colors = ButtonDefaults.buttonColors(Color.White),
            elevation = ButtonDefaults.buttonElevation(8.dp)

        ) {
            Text(text = "Pattern", color = Color.Black)
            Icon(imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "DropDown",
                tint = Color.Black
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Pattern 1") },
                onClick = { Toast.makeText(context, "Pattern 1", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                text = { Text("Pattern 2") },
                onClick = { Toast.makeText(context, "Pattern 2", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                text = { Text("Pattern 3") },
                onClick = { Toast.makeText(context, "Pattern 3", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                text = { Text("Pattern 4") },
                onClick = { Toast.makeText(context, "Pattern 4", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                text = { Text("Pattern 5") },
                onClick = { Toast.makeText(context, "Pattern 5", Toast.LENGTH_SHORT).show() }
            )
        }
    }
}

@Composable
fun TempoSliderComponent(){
    Card(modifier = Modifier
        .size(390.dp, 230.dp)
        .padding(5.dp), colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp)

    ){
        TempoCardComponent()
    }
}

@Composable
fun LiveTempoComponent(tempoState: TempoState, mediaPlayer: MediaPlayer) {
    Box(
        modifier = Modifier
            .size(385.dp, 295.dp)
            .padding(5.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(15.dp))
            .shadow(5.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TempoButtonComponent("-30", tempoState, mediaPlayer, -30)
                Spacer(modifier = Modifier.width(10.dp))
                TempoButtonComponent("-15", tempoState, mediaPlayer, -15)
                Spacer(modifier = Modifier.width(10.dp))
                TempoButtonComponent("+15", tempoState, mediaPlayer, +30)
                Spacer(modifier = Modifier.width(10.dp))
                TempoButtonComponent("+30", tempoState, mediaPlayer, +15)
            }

            SpeedDonut(
                percent1 = 0.5f,
                percent2 = 0.6f,
                strokeWidth = 15.dp,
                color1 = Color.Cyan,
                color2 = Color.Blue
            )
        }
    }
}

fun updateTempoAndPlaybackSpeed(tempo: Int, mediaPlayer: MediaPlayer) {
    val playbackParams = PlaybackParams()
    playbackParams.speed = 1.0f + tempo / 100.0f
    mediaPlayer.playbackParams = playbackParams
}





