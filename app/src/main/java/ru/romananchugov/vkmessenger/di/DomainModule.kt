package ru.romananchugov.vkmessenger.di

import org.koin.dsl.module
import ru.romananchugov.data.chats_list.ChatsListRepositoryImpl
import ru.romananchugov.domain.chats_list.ChatsListRepository
import ru.romananchugov.domain.chats_list.ChatsListUseCase

val useCaseModule = module {
    single<ChatsListRepository> { ChatsListRepositoryImpl() }
    single { ChatsListUseCase(get()) }
}