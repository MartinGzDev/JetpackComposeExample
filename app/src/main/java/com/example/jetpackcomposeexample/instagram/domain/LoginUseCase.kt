package com.example.jetpackcomposeexample.instagram.domain

import com.example.jetpackcomposeexample.instagram.data.repository.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(user:String, password: String): Boolean {
        return repository.doLogin(user,password)
    }
}