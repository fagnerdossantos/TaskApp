package com.ninhosantos.taskapp.components

import androidx.compose.foundation.Image
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.ninhosantos.taskapp.R
import com.ninhosantos.taskapp.ui.theme.Purple700

@Composable
fun CustomFloatingButton(navController: NavController) {

    FloatingActionButton(
        onClick = { navController.navigate("SaveTask") },
        backgroundColor = Purple700
    ) {

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
            contentDescription = "Add note Icon"
        )
    }
}