package com.example.naverlogin.data.datasource

import android.content.Context

interface AuthDataSource {

    suspend fun login(context: Context): Result<String>
    suspend fun logout(): Result<Unit>
    fun getValidToken(): String?
}