package ru.romananchugov.vkmessenger.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.romananchugov.vkmessenger.chats_list.ChatsListViewModel

val viewModelsModule = module {

    viewModel { ChatsListViewModel() }
}