package live.erol.testcase.data.entity


import com.google.gson.annotations.SerializedName

data class MessageResponse(
    @SerializedName("messages")
    val messages: List<Message>
)