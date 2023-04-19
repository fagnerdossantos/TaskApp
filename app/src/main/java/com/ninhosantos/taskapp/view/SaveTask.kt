package com.ninhosantos.taskapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ninhosantos.taskapp.components.CustomAppBar
import com.ninhosantos.taskapp.components.CustomRadioButtons
import com.ninhosantos.taskapp.components.CustomTextBox
import com.ninhosantos.taskapp.components.Priority
import com.ninhosantos.taskapp.ui.theme.Purple700

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SaveTask(navController: NavController) {


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
                .padding(horizontal = 30.dp),

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
            
            // Button
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                backgroundColor = Purple700

            )) {
                Text(text = "Save Task")
            }
        }

    }
}