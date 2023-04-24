package com.ninhosantos.taskapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ninhosantos.taskapp.ui.theme.TaskAppTheme
import com.ninhosantos.taskapp.view.SaveTask
import com.ninhosantos.taskapp.view.TaskList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskAppTheme {

                // Navigation
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "TaskList") {

                    composable(route = "TaskList") { TaskList(navController) }
                    composable(route = "SaveTask") { SaveTask(navController) }
                }
            }
        }
    }
}
