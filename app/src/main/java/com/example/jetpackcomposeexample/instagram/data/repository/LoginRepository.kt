package com.example.jetpackcomposeexample.instagram.data.repository

import com.example.jetpackcomposeexample.instagram.data.network.LoginService

class LoginRepository {
    private val api = LoginService()

    suspend fun doLogin(user:String, password: String): Boolean{
        return api.doLogin(user, password)
    }
}