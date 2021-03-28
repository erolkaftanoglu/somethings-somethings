package live.erol.mediatopiatestcase.data.remote

import javax.inject.Inject

class MessageRemoteDataSource @Inject constructor(private val apiService: ApiService) :
    BaseDataSource() {

    suspend fun getMessages() = getResult { apiService.getAllMessages() }
}