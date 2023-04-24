package com.ninhosantos.taskapp.components

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ninhosantos.taskapp.ui.theme.ButtonShapes
import com.ninhosantos.taskapp.ui.theme.Purple700

@Composable
fun CustomButton(modifier: Modifier,label: String, callBack: () -> Unit) {

    Button(
        modifier = modifier,
        shape = ButtonShapes.small,
        onClick = callBack, colors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700

        )
    ) {
        Text(text = label)
    }

}