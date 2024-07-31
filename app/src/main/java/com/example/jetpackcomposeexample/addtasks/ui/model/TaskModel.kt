package com.example.jetpackcomposeexample.addtasks.ui.model

import com.example.jetpackcomposeexample.addtasks.data.TaskEntity

data class TaskModel(val id: Int = System.currentTimeMillis().hashCode(), val task:String, var selected:Boolean = false)

fun TaskEntity.toDomain() = TaskModel(this.id, this.task, this.selected)
fun TaskModel.toData():TaskEntity = TaskEntity(this.id, this.task, this.selected)