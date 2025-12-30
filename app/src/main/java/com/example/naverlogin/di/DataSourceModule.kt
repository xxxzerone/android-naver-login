package com.example.naverlogin.di

import com.example.naverlogin.data.datasource.AuthDataSource
import com.example.naverlogin.data.datasource.NaverLoginDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<AuthDataSource> { NaverLoginDataSource() }
}
