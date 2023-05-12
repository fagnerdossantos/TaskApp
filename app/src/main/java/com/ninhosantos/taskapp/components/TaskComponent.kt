package com.ninhosantos.taskapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ninhosantos.taskapp.model.TaskModel
import com.ninhosantos.taskapp.ui.theme.ButtonShapes
import com.ninhosantos.taskapp.ui.theme.Purple500

@Composable
fun TaskComponent(
    position: Int, taskList: MutableList<TaskModel>
) {

    val title = taskList[position].title
    val description = taskList[position].text
    val priority = taskList[position].priority

    val priorityStatus = when (priority) {
        0 -> "No priority"
        1 -> "Low"
        2 -> "Medium"
        3 -> "High"
        else -> ""
    }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                10.dp
            ),

        backgroundColor = Purple500
    ) {

        ConstraintLayout(modifier = Modifier.padding(20.dp)) {
            // Vars Ref
            val (txtTitle, txtDescription, txtPriority, cardPriority, btnDelete) = createRefs()

            CustomConstraintText(text = title,
                modifier = Modifier.constrainAs(
                    txtTitle
                ) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            CustomConstraintText(text = description,
                modifier = Modifier.constrainAs(
                    txtDescription
                ) {
                    top.linkTo(txtTitle.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            CustomConstraintText(text = priorityStatus,
                modifier = Modifier.constrainAs(
                    txtPriority
                ) {
                    top.linkTo(txtDescription.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            )

            Card(
                shape = ButtonShapes.large,
                backgroundColor = Priority().colorSet(priority),
                modifier = Modifier
                    .size(30.dp)
                    .constrainAs(cardPriority) {
                        top.linkTo(txtDescription.bottom, margin = 10.dp)
                        start.linkTo(txtPriority.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                    }
            ) {}

            DeleteButton(
                id = position, modifier =
                Modifier.constrainAs(btnDelete) {
                    top.linkTo(txtDescription.bottom)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                })
        }

    }
}