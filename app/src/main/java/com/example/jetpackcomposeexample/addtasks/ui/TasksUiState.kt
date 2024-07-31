package com.example.jetpackcomposeexample.addtasks.ui

import com.example.jetpackcomposeexample.addtasks.ui.model.TaskModel

interface TasksUiState {
    object Loading: TasksUiState
    data class Error(val throwable: Throwable): TasksUiState
    data class Success(val tasks: List<TaskModel>): TasksUiState
}