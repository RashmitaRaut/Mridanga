package com.example.mridanga.Components

import android.media.AudioManager
import android.media.MediaPlayer
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mridanga.R
import com.example.mridanga.Screens.KartalScreen
import com.example.mridanga.Screens.MridangaScreen
import com.example.mridanga.Screens.TanpuraScreen
import java.lang.Exception

@Composable
fun TabNavigationComponent(){
    var tabIndex by remember { mutableStateOf(0)}

    val tabs  = listOf("Mridangam", "Kartal", "Tanpura")
    
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(text = title, color = Color.Black)},
                    selected = tabIndex == index ,
                    onClick = {tabIndex = index },
                )
            }
        }
        when (tabIndex) {
            0 -> MridangaScreen()
            1 -> KartalScreen()
            2 -> TanpuraScreen()
        }
    }
}

@Composable
fun BottomAppBarContent(){
    BottomAppBar(){
        val ctx = LocalContext.current
        val mediaPlayer = MediaPlayer()
        
        Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
        ) {

            /**********************Pause Button******************************/

            Spacer(modifier = Modifier.width(30.dp))
            IconButton(onClick = {
                if (mediaPlayer.isPlaying){
                    mediaPlayer.pause()
                    mediaPlayer.reset()
                    mediaPlayer.release()

                    Toast.makeText(ctx, "Paused", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(ctx, "Not played", Toast.LENGTH_SHORT)
                }

            }) {
                Icon(painter = painterResource(id = R.drawable.pause_button),
                    contentDescription = "Pause Button",
                    modifier = Modifier.size(100.dp)
                )
            }

            /**********************Play Button******************************/
            Spacer(modifier = Modifier.width(45.dp))

            IconButton(onClick = {
                val audioUrl = "https://bit.ly/MridangaAudio"

                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

                try {
                    mediaPlayer.setDataSource(audioUrl)

                    mediaPlayer.prepare()

                    mediaPlayer.start()
                }catch (e: Exception){
                    e.printStackTrace()
                }

                Toast.makeText(ctx, "Started", Toast.LENGTH_SHORT ).show()
            }) {
                Icon(painter = painterResource(id = R.drawable.play_button),
                    contentDescription = "Play Button",
                    modifier = Modifier.size(100.dp)
                )
            }

            /*********************************Stop Button******************************/
            Spacer(modifier = Modifier.width(45.dp))

            IconButton(onClick = {

                if (mediaPlayer.isPlaying){
                    mediaPlayer.stop()


                    Toast.makeText(ctx, "Stopped", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(ctx, "Not stopped", Toast.LENGTH_SHORT)
                }

            }) {
                Icon(painter = painterResource(id = R.drawable.pause_button),
                    contentDescription = "Stop Button",
                    modifier = Modifier.size(100.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(45.dp))

            /*********************************Mixer Button******************************/


            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.dj_mixer),
                    contentDescription = "Mixer Button" )
            }
        }
        }
        
    }

