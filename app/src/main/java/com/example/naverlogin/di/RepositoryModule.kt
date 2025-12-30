package com.example.naverlogin.di

import com.example.naverlogin.data.repository.AuthRepositoryImpl
import com.example.naverlogin.domain.repository.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
}
