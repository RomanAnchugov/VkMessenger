package ru.romananchugov.vkmessenger.chats_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vk.api.sdk.utils.VKUtils
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.romananchugov.vkmessenger.R
import ru.romananchugov.vkmessenger.base_classes.BaseFragment
import timber.log.Timber

class ChatsListFragment : BaseFragment(){

    companion object{
        private const val TAG = "ChatsListFragment"
    }

    private val chatsListViewModel: ChatsListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //chatsListViewModel.test()
        //Timber.getCertificateFingerprint(requireContext(), requireContext().packageName)
        val fingerprints = VKUtils.getCertificateFingerprint(requireContext(), requireContext().packageName)
        fingerprints?.forEach {
            Timber.tag(TAG).i(it)
        }
        return inflater.inflate(R.layout.fragment_chats_list, container, false)

    }
}