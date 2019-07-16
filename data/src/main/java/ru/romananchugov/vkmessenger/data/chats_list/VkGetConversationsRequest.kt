package ru.romananchugov.vkmessenger.data.chats_list

import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject
import ru.romananchugov.vkmessenger.domain.chats_list.VkConversationWithMessageModel
import ru.romananchugov.vkmessenger.domain.chats_list.VkConversationsResponseModel

class VkGetConversationsRequest: VKRequest<VkConversationsResponseModel>("messages.getConversations") {

    override fun parse(r: JSONObject): VkConversationsResponseModel {
        val response = r.getJSONObject("response")
        val count = response.getInt("count")
        val items: MutableCollection<VkConversationWithMessageModel>
    }
}