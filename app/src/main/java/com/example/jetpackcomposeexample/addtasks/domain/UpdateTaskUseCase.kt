package com.example.jetpackcomposeexample.addtasks.domain

import com.example.jetpackcomposeexample.addtasks.data.TaskRepository
import com.example.jetpackcomposeexample.addtasks.ui.model.TaskModel
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(taskModel: TaskModel){
        taskRepository.update(taskModel)
    }
}