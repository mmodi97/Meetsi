package com.tools.meetsi.repository

import com.infinty8.flashcall.db.MeetingDao
import com.tools.meetsi.model.Meeting

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(private val meetingDao: MeetingDao) {

    suspend fun addMeetingToDb(meeting: Meeting) = withContext(Dispatchers.IO) {
        meetingDao.insertMeeting(meeting)
    }

}