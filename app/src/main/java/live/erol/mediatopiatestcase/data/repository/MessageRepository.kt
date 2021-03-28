package live.erol.mediatopiatestcase.data.repository

import live.erol.mediatopiatestcase.data.remote.MessageRemoteDataSource
import live.erol.mediatopiatestcase.utils.performNetworkOperation
import javax.inject.Inject

class MessageRepository @Inject constructor(private val remoteDataSource: MessageRemoteDataSource) {
    fun getMessages() = performNetworkOperation(networkCall = { remoteDataSource.getMessages() })
}