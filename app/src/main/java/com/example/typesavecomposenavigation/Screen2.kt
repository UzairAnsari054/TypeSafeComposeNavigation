package com.example.typesavecomposenavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Screen2(
    num: Int,
    onNavigateToNextScreen: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Screen 2", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(24.dp))

        Text(text = num.toString(), fontSize = 24.sp)
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { onNavigateToNextScreen() }) {
            Text(text = "Go to Screen3", fontSize = 24.sp)
        }
    }
}