package com.ninhosantos.taskapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

import com.ninhosantos.taskapp.components.CustomAppBar
import com.ninhosantos.taskapp.components.CustomFloatingButton

@Composable
fun TaskList(navController: NavController) {

    Scaffold(

        // App Bar
        topBar = { CustomAppBar(label = "Tasks") },

        // Floating Button
        floatingActionButton = { CustomFloatingButton(navController) }

    ) {

            PaddingVal ->

        // App Body
        Column(modifier = Modifier.padding(PaddingVal)) {

        }

    }
}

