package com.example.naverlogin.di

import com.example.naverlogin.data.api.AuthService
import com.example.naverlogin.data.api.AuthServiceImpl
import com.example.naverlogin.data.datastore.TokenManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { TokenManager(androidContext()) }
    single<AuthService> { AuthServiceImpl(get()) }
}
