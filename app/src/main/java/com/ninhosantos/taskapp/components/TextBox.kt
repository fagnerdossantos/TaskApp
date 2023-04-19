package com.ninhosantos.taskapp.components

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ninhosantos.taskapp.ui.theme.*

@Composable
fun CustomTextBox(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int
) {
    OutlinedTextField(
        value = value, onValueChange = onValueChange, modifier = modifier, label = {
            Text(
                text = label
            )
        }, colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Black,
            focusedBorderColor = Purple200,
            focusedLabelColor = Purple200,
            backgroundColor = White,
            cursorColor = Purple200

        ), shape = TextBoxShapes.small, maxLines = maxLines
    )
}
