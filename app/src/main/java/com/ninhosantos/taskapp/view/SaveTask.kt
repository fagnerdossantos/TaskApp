package com.ninhosantos.taskapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ninhosantos.taskapp.components.*
import com.ninhosantos.taskapp.model.TaskModel
import com.ninhosantos.taskapp.viewmodel.TaskViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SaveTask(navController: NavController) {

    // Controller
    val controller = TaskViewModel.getInstance()

    // Fields States
    val priority = Priority()

    var taskTitle by remember {
        mutableStateOf(value = "")
    }

    var taskDescription by remember {
        mutableStateOf(value = "")
    }

    Scaffold(

        // App Bar
        topBar = { CustomAppBar(label = "Save Task") },


        ) {


        // App Body
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 30.dp)
                .verticalScroll(rememberScrollState()),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Title Box
            CustomTextBox(
                value = taskTitle,
                onValueChange = {
                    taskTitle = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = "Title",
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Task Box
            CustomTextBox(
                value = taskDescription,
                onValueChange = {
                    taskDescription = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                label = "Description",
                maxLines = 4
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Priority
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text("Priority Level: ")

                for (i in 0..2)
                    CustomRadioButtons(
                        isSelected = priority.checkPriority(i),
                        index = i,

                        callBack = {
                            priority.changePriority(i)
                        })
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Button
            CustomButton(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), label = "Save Task", callBack = {
                    controller.createTask(TaskModel(title = taskTitle, text = taskDescription, priority = 0))
                navController.popBackStack()
            })
        }

    }
}