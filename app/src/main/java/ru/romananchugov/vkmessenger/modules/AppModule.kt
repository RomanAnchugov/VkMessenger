package ru.romananchugov.vkmessenger.modules

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.romananchugov.vkmessenger.chats_list.ChatsListViewModel

val viewModelsModule = module {

    viewModel { ChatsListViewModel() }
}