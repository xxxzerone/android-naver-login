package com.example.naverlogin.ui.login

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.naverlogin.ui.component.NaverLogin

@Composable
fun LoginScreen(
    state: LoginState,
    context: Context,
    modifier: Modifier = Modifier,
    onAction: (LoginAction) -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            state.isLoading -> CircularProgressIndicator()
            else -> NaverLogin { onAction(LoginAction.OnNaverLoginClick(context)) }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    val context = LocalContext.current

    LoginScreen(
        state = LoginState(),
        context = context
    )
}