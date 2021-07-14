package com.tools.meetsi.di

import com.tools.meetsi.repository.MeetingHistoryRepository
import com.tools.meetsi.viewmodel.MeetingHistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val meetingHistoryModule = module {

    single { MeetingHistoryRepository(get()) }
    viewModel { MeetingHistoryViewModel(get()) }

}
