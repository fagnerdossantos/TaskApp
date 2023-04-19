package com.ninhosantos.taskapp.components

import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.*
import com.ninhosantos.taskapp.ui.theme.Green
import com.ninhosantos.taskapp.ui.theme.Red
import com.ninhosantos.taskapp.ui.theme.Yellow

@Composable
fun CustomRadioButtons(isSelected: Boolean, index: Int, callBack: (() -> Unit)) {
    RadioButton(
        selected = isSelected, onClick = callBack, colors = RadioButtonDefaults.colors(
            selectedColor = when (index) {
                0 -> Green
                1 -> Yellow
                else -> Red
            }
        )
    )
}

class Priority {

    private var selectedIndex: MutableState<Int> = mutableStateOf(0)

    fun checkPriority(index: Int): Boolean {
        return index == selectedIndex.value
    }

    fun changePriority(index: Int) {
        selectedIndex.value = index
    }
}