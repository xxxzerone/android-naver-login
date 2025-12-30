package com.example.naverlogin.ui.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naverlogin.domain.repository.AuthRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<LoginEvent>()
    val event = _event.asSharedFlow()

    fun handleAction(action: LoginAction) {
        when (action) {
            is LoginAction.OnNaverLoginClick -> login(action.context)
            is LoginAction.CheckAutoLogin -> checkAutoLogin()
        }
    }

    private fun checkAutoLogin() {
        viewModelScope.launch {
            if (repository.checkAutoLogin()) {
                _event.emit(LoginEvent.NavigateToMain)
            }
        }
    }

    private fun login(context: Context) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            repository.loginWithNaver(context)
                .onSuccess {
                    _state.update { it.copy(isLoading = false, isLoggedIn = true) }
                    _event.emit(LoginEvent.ShowToast("로그인 성공!"))
                    _event.emit(LoginEvent.NavigateToMain)
                }
                .onFailure { e ->
                    _state.update { it.copy(isLoading = false) }
                    _event.emit(LoginEvent.ShowToast("로그인 실패: ${e.message}"))
                }
        }
    }
}