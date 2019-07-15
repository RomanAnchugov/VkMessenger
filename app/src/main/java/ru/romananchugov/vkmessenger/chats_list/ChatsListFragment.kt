package ru.romananchugov.vkmessenger.chats_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.romananchugov.vkmessenger.R
import ru.romananchugov.vkmessenger.base_classes.BaseFragment
import timber.log.Timber

class ChatsListFragment : BaseFragment(){

    private val chatsListViewModel: ChatsListViewModel by viewModel()

    companion object{
        private const val TAG = "ChatsListFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chats_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chatsListViewModel.onViewCreated()

        chatsListViewModel.chatsList.observe(this, Observer {
            Timber.i("Hello from observer ${it.size}")
        })

        chatsListViewModel.isLoggedIn.observe(this, Observer {
            Timber.i("Is Logged in with Clean $it")
        })
    }
}