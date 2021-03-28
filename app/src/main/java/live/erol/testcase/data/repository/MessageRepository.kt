package live.erol.testcase.data.repository

import live.erol.testcase.data.remote.MessageRemoteDataSource
import live.erol.testcase.utils.performNetworkOperation
import javax.inject.Inject

class MessageRepository @Inject constructor(private val remoteDataSource: MessageRemoteDataSource) {
    fun getMessages() = performNetworkOperation(networkCall = { remoteDataSource.getMessages() })
}