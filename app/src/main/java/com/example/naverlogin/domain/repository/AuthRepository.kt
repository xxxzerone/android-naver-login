package com.example.naverlogin.domain.repository

import android.content.Context

interface AuthRepository {
    suspend fun checkAutoLogin(): Boolean
    suspend fun loginWithNaver(context: Context): Result<String>
    suspend fun logout()
}
