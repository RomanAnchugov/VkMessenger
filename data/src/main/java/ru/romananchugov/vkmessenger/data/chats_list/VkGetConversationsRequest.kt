package ru.romananchugov.vkmessenger.data.chats_list

import com.squareup.moshi.Moshi
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject
import ru.romananchugov.vkmessenger.domain.chats_list.VkConversationsResponseModel

class VkGetConversationsRequest: VKRequest<VkConversationsResponseModel?>("messages.getConversations") {

    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter<VkConversationsResponseModel>(VkConversationsResponseModel::class.java)

    override fun parse(r: JSONObject): VkConversationsResponseModel? {
        val response = r.getJSONObject("response")
        val elClass: VkConversationsResponseModel? = adapter.fromJson(response.toString())
        return elClass
    }
}