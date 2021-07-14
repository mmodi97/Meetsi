package com.tools.meetsi


import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.chibatching.kotpref.Kotpref
import com.tools.meetsi.di.appModule
import com.tools.meetsi.di.mainModule
import com.tools.meetsi.di.meetingHistoryModule
import com.tools.meetsi.sharedpref.AppPref
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MeetCall : Application() {


    override fun onCreate() {
        super.onCreate()

        initializeKotPref()
        setThemeMode()
        initializeKoin()
    }

    private fun initializeKotPref() {
        Kotpref.init(this)
    }

    private fun setThemeMode() {
        if (AppPref.isLightThemeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }

    private fun initializeKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MeetCall)
            modules(
                listOf(
                    appModule,
                    mainModule,
                    meetingHistoryModule
                )
            )
        }
    }


}