package com.example.jetpackcomposeexample.addtasks.data.di

import android.content.Context
import androidx.room.Room
import com.example.jetpackcomposeexample.addtasks.data.TaskDao
import com.example.jetpackcomposeexample.addtasks.data.TodoDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideTasksDao(todoDataBase: TodoDataBase): TaskDao{
        return todoDataBase.taskDao()
    }

    @Provides
    @Singleton
    fun provideTodoDatabase(@ApplicationContext appContext: Context): TodoDataBase{
        return Room.databaseBuilder(appContext, TodoDataBase::class.java, "TaskDataBase").build()
    }
}