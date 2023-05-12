package com.ninhosantos.taskapp.components

import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.*
import com.ninhosantos.taskapp.ui.theme.Black
import com.ninhosantos.taskapp.ui.theme.Green
import com.ninhosantos.taskapp.ui.theme.Red
import com.ninhosantos.taskapp.ui.theme.Yellow

@Composable
fun CustomRadioButtons(isSelected: Boolean, index: Int, callBack: () -> Unit) {


    RadioButton(

        selected = isSelected, onClick = callBack,
        colors = RadioButtonDefaults.colors(

            selectedColor = Priority().colorSet(index),
            unselectedColor = Priority().colorSet(index)
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

    fun colorSet(index: Int) = when (index) {
        0 -> Black
        1 -> Green
        2 -> Yellow
        else -> Red
    }
}