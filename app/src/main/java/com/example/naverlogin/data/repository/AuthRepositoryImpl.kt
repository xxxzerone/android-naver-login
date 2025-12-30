package com.example.naverlogin.data.repository

import android.content.Context
import com.example.naverlogin.data.datasource.AuthDataSource
import com.example.naverlogin.data.datastore.TokenManager
import com.example.naverlogin.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val dataSource: AuthDataSource,
    private val tokenManager: TokenManager
) : AuthRepository {
    override suspend fun checkAutoLogin(): Boolean {
        val savedToken = dataSource.getValidToken()
        return if (savedToken != null) {
            tokenManager.saveToken(savedToken)
            true
        } else {
            false
        }
    }

    override suspend fun loginWithNaver(context: Context): Result<String> {
        return dataSource.login(context).onSuccess { token ->
            tokenManager.saveToken(token)
        }
    }

    override suspend fun logout() {
        dataSource.logout()
        tokenManager.clearToken()
    }
}