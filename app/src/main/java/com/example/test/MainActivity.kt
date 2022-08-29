package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBottomNavigation()
        }
    }
}

@Preview
@Composable
fun MyBottomNavigation() {
    var bottomState by remember {
        mutableStateOf("Home")
    }
    Scaffold(
        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
                Alignment.Center
            ) {
                Text(
                    text = bottomState,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(
                    shape = RoundedCornerShape(
                        30.dp
                    )
                ),
                backgroundColor = Color(0xFFFEDBD0),
                contentColor = Color(0xFF442c2E)
            ) {
                BottomNavigationItem(
                    selected = bottomState == "Home",
                    onClick = { bottomState = "Home" },
                    label = { Text(text = "Home") },
                    icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = null) })
                BottomNavigationItem(
                    selected = bottomState == "Downloads",
                    onClick = { bottomState = "Downloads" },
                    label = { Text(text = "Downloads") },
                    icon = { Icon(imageVector = Icons.Filled.Download, contentDescription = null) })
                BottomNavigationItem(
                    selected = bottomState == "Settings",
                    onClick = { bottomState = "Settings" },
                    label = { Text(text = "Settings") },
                    icon = { Icon(imageVector = Icons.Filled.Settings, contentDescription = null) })
            }
        })
}