package ru.romananchugov.vkmessenger

import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.romananchugov.vkmessenger.base_classes.BaseActivity
import ru.romananchugov.vkmessenger.chats_list.ChatsListViewModel


class  MainActivity : BaseActivity() {

    //TEST
    val myViewModel: ChatsListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myViewModel.test()
    }
}
