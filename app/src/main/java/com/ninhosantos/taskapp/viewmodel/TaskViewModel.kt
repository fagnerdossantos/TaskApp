package com.ninhosantos.taskapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import com.ninhosantos.taskapp.model.TaskModel

class TaskViewModel private constructor() {

    private val taskList = mutableStateListOf<TaskModel>()

    fun loadTask() = taskList

    fun createTask(task: TaskModel) = taskList.add(task)

    fun deleteTask(index: Int) = taskList.removeAt(index)



    // Singleton
    companion object {
        @Volatile
        private var instance: TaskViewModel? = null

        fun getInstance(): TaskViewModel {
            return instance ?: synchronized(this) {
                instance ?: TaskViewModel().also { instance = it }
            }
        }
    }
}