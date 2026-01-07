package com.example.naverlogin.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naverlogin.domain.repository.AuthRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    fun signOut() {
        Log.d("HomeViewModel", "signOut")
        viewModelScope.launch {
            repository.logout()
        }
    }
}