package ru.romananchugov.vkmessenger.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.romananchugov.vkmessenger.authentification.AuthenticationViewModel

val viewModelsModule = module{
    viewModel { AuthenticationViewModel() }
}