package com.example.naverlogin.ui.login

sealed interface LoginEvent {
    data object NavigateToMain : LoginEvent
    data class ShowToast(val message: String) : LoginEvent
}
