package com.tools.meetsi.di


import android.app.Application
import androidx.room.Room
import com.tools.meetsi.db.MeetlyDB
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {

    single { provideRoomDatabase(androidApplication()) }
    single { provideMeetingDao(get()) }
}

private fun provideRoomDatabase(androidApplication: Application) =
    Room.databaseBuilder(androidApplication, MeetlyDB::class.java, "meetsi-db").build()

private fun provideMeetingDao(meetlyDB: MeetlyDB) =
    meetlyDB.meetingDao()