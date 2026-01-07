package com.example.naverlogin.data.api

import com.example.naverlogin.data.dto.FirebaseTokenDto
import com.example.naverlogin.data.dto.NaverTokenRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AuthServiceImpl(
    private val httpClient: HttpClient,
) : AuthService {
    override suspend fun getFirebaseCustomToken(accessToken: String): FirebaseTokenDto {
        val response = httpClient.post("/auth/naver") {
            contentType(ContentType.Application.Json)
            setBody(NaverTokenRequest(accessToken))
        }

        return response.body()
    }
}