package ru.romananchugov.vkmessenger.di

import org.koin.dsl.module
import ru.romananchugov.vkmessenger.data.chats_list.ChatsListRepositoryImpl
import ru.romananchugov.vkmessenger.domain.chats_list.ChatsListRepository
import ru.romananchugov.vkmessenger.domain.chats_list.ChatsListUseCase

val useCaseModule = module {

    //ChatsList
    single<ChatsListRepository> { ChatsListRepositoryImpl() }
    single { ChatsListUseCase(get()) }
}