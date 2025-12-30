package com.example.naverlogin.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

interface Route : NavKey {
    @Serializable
    data object Home : Route

    @Serializable
    data object Login : Route
}