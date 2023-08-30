package com.example.mridanga.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mridanga.Components.LiveTempoComponent
import com.example.mridanga.Components.PatternDropDownComponent
import com.example.mridanga.Components.TaalDropDownComponent
import com.example.mridanga.Components.TempoSliderComponent

@Composable
fun MridangaScreen(){
    Column() {
        Spacer(modifier = Modifier.height(10.dp))

        Row {
            TaalDropDownComponent()
            Spacer(modifier = Modifier.width(15.dp))
            PatternDropDownComponent()
        }

        Spacer(modifier = Modifier.height(15.dp))
        TempoSliderComponent()
        Spacer(modifier = Modifier.height(15.dp))
        LiveTempoComponent()



    }

}