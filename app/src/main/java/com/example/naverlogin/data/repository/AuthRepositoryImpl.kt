package com.example.naverlogin.data.repository

import android.content.Context
import android.util.Log
import com.example.naverlogin.data.api.AuthService
import com.example.naverlogin.data.datasource.AuthDataSource
import com.example.naverlogin.data.datastore.TokenManager
import com.example.naverlogin.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl(
    private val dataSource: AuthDataSource,
    private val tokenManager: TokenManager,
    private val firebaseAuth: FirebaseAuth,
    private val authService: AuthService
) : AuthRepository {
    override suspend fun checkAutoLogin(): Boolean {
        val savedToken = tokenManager.accessToken.firstOrNull()
        val currentUser = firebaseAuth.currentUser

        return !savedToken.isNullOrBlank() && currentUser != null
    }

    override suspend fun loginWithNaver(context: Context): Result<String> {
        return try {
            val naverResult = dataSource.login(context).getOrThrow()

            val response = authService.getFirebaseCustomToken(naverResult)

            val customToken = checkNotNull(response.firebaseToken) {
                "서버로부터 Firebase 토큰을 받아오지 못했습니다."
            }

            val authResult = firebaseAuth.signInWithCustomToken(customToken).await()
            val uid = authResult.user?.uid ?: throw Exception("Firebase 유저 정보가 없습니다.")

            tokenManager.saveToken(uid)

            Result.success(uid)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun logout() {
        dataSource.logout()
        tokenManager.clearToken()
    }
}