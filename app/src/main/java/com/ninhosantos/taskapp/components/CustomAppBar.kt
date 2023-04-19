package com.ninhosantos.taskapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ninhosantos.taskapp.ui.theme.Purple700
import com.ninhosantos.taskapp.ui.theme.White


@Composable
fun CustomAppBar(label: String) {
    TopAppBar(backgroundColor = Purple700) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center)
        {
            Text(
                text = label,
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold, color = White)
            )
        }

    }
}