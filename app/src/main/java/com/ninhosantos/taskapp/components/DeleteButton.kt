package com.ninhosantos.taskapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.ninhosantos.taskapp.R
import com.ninhosantos.taskapp.viewmodel.TaskViewModel

@Composable
fun DeleteButton(modifier: Modifier, id: Int) {

    val instance = TaskViewModel.getInstance()

    IconButton(modifier = modifier.size(40.dp),
        onClick = { instance.deleteTask(index = id) }) {
        Image(
            modifier = Modifier.fillMaxSize(),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete),
            contentDescription = "Delete Icon"
        )
    }
}