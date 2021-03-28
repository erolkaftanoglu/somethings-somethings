package live.erol.testcase.data.entity


import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("id")
    val id: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("timestamp")
    val timestamp: Long,
    @SerializedName("user")
    val user: User
)