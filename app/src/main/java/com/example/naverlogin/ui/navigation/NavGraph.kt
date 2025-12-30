package com.example.naverlogin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.naverlogin.ui.home.HomeScreen
import com.example.naverlogin.ui.login.LoginScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val backstack = rememberNavBackStack(Route.Home)

    NavDisplay(
        modifier = modifier,
        backStack = backstack,
        onBack = { backstack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Route.Home> {
                HomeScreen(
                    onNavigateSignIn = {
                        backstack.clear()
                        backstack.add(Route.Login)
                    }
                )
            }
            entry<Route.Login> {
                LoginScreen()
            }
        }
    )
}