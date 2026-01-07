package com.example.naverlogin.data.api

import com.example.naverlogin.data.dto.FirebaseTokenDto

interface AuthService {
    suspend fun getFirebaseCustomToken(accessToken: String): FirebaseTokenDto
}