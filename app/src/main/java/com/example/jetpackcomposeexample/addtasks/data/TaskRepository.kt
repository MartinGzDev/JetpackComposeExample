package com.example.jetpackcomposeexample.addtasks.data

import com.example.jetpackcomposeexample.addtasks.ui.model.TaskModel
import com.example.jetpackcomposeexample.addtasks.ui.model.toData
import com.example.jetpackcomposeexample.addtasks.ui.model.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(private val taskDao: TaskDao){

    val tasks: Flow<List<TaskModel>> = taskDao.getTasks().map { item ->  item.map { it.toDomain() } }

    suspend fun add(taskModel: TaskModel){
        taskDao.addTask(taskModel.toData())
    }

    suspend fun update(taskModel: TaskModel) {
        taskDao.updateTask(taskModel.toData())
    }

    suspend fun delete(taskModel: TaskModel) {
        taskDao.deleteTask(taskModel.toData())
    }
}