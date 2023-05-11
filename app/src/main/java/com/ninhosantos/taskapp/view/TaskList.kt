package com.ninhosantos.taskapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

import com.ninhosantos.taskapp.components.CustomAppBar
import com.ninhosantos.taskapp.components.CustomFloatingButton
import com.ninhosantos.taskapp.components.TaskComponent
import com.ninhosantos.taskapp.model.TaskModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TaskList(navController: NavController) {

    Scaffold(

        // App Bar
        topBar = { CustomAppBar(label = "Tasks") },

        // Floating Button
        floatingActionButton = { CustomFloatingButton(navController) }

    ) {

        val taskList: MutableList<TaskModel> = mutableListOf(
            TaskModel("First", "Description", 0),
            TaskModel("Second", "Description", 1),
            TaskModel("third", "Description", 2),
            )

        // App Body
        LazyColumn {
            itemsIndexed(taskList) {
                position, _ -> TaskComponent(position, taskList)
            }
        }
    }
}

