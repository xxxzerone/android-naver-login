package com.example.naverlogin.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class FirebaseTokenDto(
    val firebaseToken: String? = null
)

@Serializable
data class NaverTokenRequest(val accessToken: String)