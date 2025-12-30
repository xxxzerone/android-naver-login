package com.example.naverlogin.ui.login

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.navercorp.nid.NidOAuth
import com.navercorp.nid.oauth.util.NidOAuthCallback
import com.navercorp.nid.oauth.view.NidLoginButton

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val oauthLoginCallback = object : NidOAuthCallback {
        override fun onSuccess() {
            val accessToken = NidOAuth.getAccessToken()
            Log.d("NaverLogin", "Login Success. AccessToken: $accessToken")
        }

        override fun onFailure(errorCode: String, errorDesc: String) {
            val errorCode = NidOAuth.getLastErrorCode().code
            val errorDescription = NidOAuth.getLastErrorDescription()
            Log.e("NaverLogin", "Login Failed. ErrorCode: $errorCode, ErrorDescription: $errorDescription")

        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AndroidView(
            factory = { context ->
                NidLoginButton(context).apply {
                    setOAuthLogin(oauthLoginCallback)
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}