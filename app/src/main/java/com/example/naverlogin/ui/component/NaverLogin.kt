package com.example.naverlogin.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.naverlogin.R.drawable
import com.example.naverlogin.R.string
import com.example.naverlogin.ui.theme.Naver

@Composable
fun NaverLogin(
    onClick: () -> Unit = {}
) {
    LoginButton(
        backgroundColor = Naver,
        iconResId = drawable.ico_naver_18x18,
        contentDescription = stringResource(id = string.login_naver),
        buttonText = stringResource(id = string.login_naver),
        textColor = Color.White,
        onClick = onClick
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun NaverLoginPreview() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        NaverLogin()
    }
}