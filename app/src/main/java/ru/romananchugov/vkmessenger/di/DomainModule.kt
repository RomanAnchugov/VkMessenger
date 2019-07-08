package ru.romananchugov.vkmessenger.di

import org.koin.dsl.module
import ru.romananchugov.data.chats_list.ChatsListRepository
import ru.romananchugov.domain.chats_list.ChatsListUseCase

val useCaseModule = module {
    single { ChatsListRepository() }
    single { ChatsListUseCase(get()) }
}