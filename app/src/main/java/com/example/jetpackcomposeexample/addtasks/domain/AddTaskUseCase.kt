package com.example.jetpackcomposeexample.addtasks.domain

import com.example.jetpackcomposeexample.addtasks.data.TaskRepository
import com.example.jetpackcomposeexample.addtasks.ui.model.TaskModel
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(private val repository: TaskRepository) {

    suspend operator fun invoke(taskModel: TaskModel){
        repository.add(taskModel)
    }
}