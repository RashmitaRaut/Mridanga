package com.example.mridanga

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mridanga.Components.BottomAppBarContent
import com.example.mridanga.Components.TabNavigationComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(){
    Scaffold(
        topBar = { TopAppBar(title = { Text("Home")}) },
        content = { MyContent()},
        bottomBar = { BottomAppBarContent() }
    )
}

@Composable
fun MyContent(){
    Column {
        Spacer(modifier = Modifier.height(55.dp))
            TabNavigationComponent()
        }
    }

