package live.erol.mediatopiatestcase.data.entity


import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("id")
    val id: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("timestamp")
    val timestamp: Int,
    @SerializedName("user")
    val user: User
)