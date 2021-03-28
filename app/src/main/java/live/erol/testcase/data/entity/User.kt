package live.erol.testcase.data.entity


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("avatarURL")
    val avatarURL: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("nickname")
    val nickname: String
)