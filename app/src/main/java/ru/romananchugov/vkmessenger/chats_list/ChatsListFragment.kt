package ru.romananchugov.vkmessenger.chats_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.romananchugov.vkmessenger.R
import ru.romananchugov.vkmessenger.base_classes.BaseFragment

class ChatsListFragment : BaseFragment(){

    private val chatsListViewModel: ChatsListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        chatsListViewModel.test()
        return inflater.inflate(R.layout.fragment_chats_list, container, false)
    }
}