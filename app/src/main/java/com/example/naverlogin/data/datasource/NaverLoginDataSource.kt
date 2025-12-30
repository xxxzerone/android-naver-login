package com.example.naverlogin.data.datasource

import android.content.Context
import com.navercorp.nid.NidOAuth
import com.navercorp.nid.oauth.util.NidOAuthCallback
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class NaverLoginDataSource : AuthDataSource {
    
    override suspend fun login(context: Context): Result<String> = suspendCancellableCoroutine { continuation ->
        val callback = object : NidOAuthCallback {
            override fun onSuccess() {
                val token = NidOAuth.getAccessToken()
                continuation.resume(Result.success(token ?: ""))
            }

            override fun onFailure(errorCode: String, errorDesc: String) {
                continuation.resume(Result.failure(Exception("[$errorCode] $errorDesc")))
            }
        }
        NidOAuth.requestLogin(context, callback)
    }

    // 로그아웃 (SDK 내부 토큰 삭제)
    override suspend fun logout(): Result<Unit> = suspendCancellableCoroutine { continuation ->
        NidOAuth.logout(object : NidOAuthCallback {
            override fun onSuccess() {
                continuation.resume(Result.success(Unit))
            }
            override fun onFailure(errorCode: String, errorDesc: String) {
                continuation.resume(Result.failure(Exception(errorDesc)))
            }
        })
    }

    override fun getValidToken(): String? {
        return NidOAuth.getAccessToken()
    }

    // 연동 해제 (네이버 서비스와 앱의 연결을 완전히 끊음)
    suspend fun disconnect(): Result<Unit> = suspendCancellableCoroutine { continuation ->
        NidOAuth.disconnect(object : NidOAuthCallback {
            override fun onSuccess() {
                continuation.resume(Result.success(Unit))
            }
            override fun onFailure(errorCode: String, errorDesc: String) {
                continuation.resume(Result.failure(Exception(errorDesc)))
            }
        })
    }
}
