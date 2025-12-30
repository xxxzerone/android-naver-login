package com.example.naverlogin.ui.login

import android.content.Context

sealed interface LoginAction {
    data object CheckAutoLogin : LoginAction
    data class OnNaverLoginClick(val context: Context) : LoginAction
}
