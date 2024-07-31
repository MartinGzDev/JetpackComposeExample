package com.example.jetpackcomposeexample.addtasks.domain

import com.example.jetpackcomposeexample.addtasks.data.TaskRepository
import com.example.jetpackcomposeexample.addtasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val repository: TaskRepository) {

    operator fun invoke(): Flow<List<TaskModel>> = repository.tasks

}