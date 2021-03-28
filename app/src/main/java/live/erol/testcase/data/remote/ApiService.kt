package live.erol.testcase.data.remote

import live.erol.testcase.data.entity.MessageResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("chatdata-example.json")
    suspend fun getAllMessages(): Response<MessageResponse>
}