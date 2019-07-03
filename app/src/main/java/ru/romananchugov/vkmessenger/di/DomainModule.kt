package ru.romananchugov.vkmessenger.di

import org.koin.dsl.module
import ru.romananchugov.domain.chats_list.ChatsListUseCase

val useCaseModule = module {
    single { ChatsListUseCase() }
}