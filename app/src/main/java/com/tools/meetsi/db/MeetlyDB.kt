package com.tools.meetsi.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.infinty8.flashcall.db.MeetingDao
import com.tools.meetsi.model.Meeting

@Database(entities = [Meeting::class], version = 1)
abstract class MeetlyDB : RoomDatabase() {

    abstract fun meetingDao(): MeetingDao

}