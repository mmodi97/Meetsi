package com.tools.meetsi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.tools.meetsi.model.Meeting
import com.tools.meetsi.repository.MeetingHistoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MeetingHistoryViewModel(private val repository: MeetingHistoryRepository) : ViewModel() {

    var meetingHistoryLiveData: LiveData<List<Meeting>> = liveData(Dispatchers.IO) {
        emitSource(repository.getMeetingHistory()) // emitSource() automatically runs on the Main thread
    }

    fun addMeetingToDb(meeting: Meeting) {
        viewModelScope.launch {
            repository.addMeetingToDb(meeting)
        }
    }

}
