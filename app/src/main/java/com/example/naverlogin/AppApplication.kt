package com.example.naverlogin

import android.app.Application
import com.navercorp.nid.NidOAuth
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        NidOAuth.initialize(
            context = this,
            clientId = BuildConfig.NAVER_CLIENT_ID,
            clientSecret = BuildConfig.NAVER_CLIENT_SECRET,
            clientName = BuildConfig.NAVER_CLIENT_NAME
        )

        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            modules()
        }
    }
}