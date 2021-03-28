package live.erol.testcase.ui.message

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import live.erol.testcase.data.entity.Message
import live.erol.testcase.data.entity.User
import live.erol.testcase.data.repository.MessageRepository
import live.erol.testcase.utils.SPref
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class MessagesViewModel @Inject constructor(
    private val sPref: SPref,
    private val repository: MessageRepository
) : ViewModel() {
    private var nicknameLiveData = MutableLiveData<String>()
    private var messageListLiveData = MutableLiveData<ArrayList<Message>>()
    private var messageLiveData = MutableLiveData<Message>()
    private var messageButtonStateLiveData = MutableLiveData<Boolean>(false)
    private var nickname = ""

    fun listenNickname(): LiveData<String> = nicknameLiveData
    fun listenMessageList(): LiveData<ArrayList<Message>> = messageListLiveData
    fun listenMessage(): LiveData<Message> = messageLiveData
    fun listenMessageButtonState(): LiveData<Boolean> = messageButtonStateLiveData

    fun getNickname() {
        nickname = sPref.getNickname()
        nicknameLiveData.value = "$nickname"
    }

    fun removeSession(): Boolean {
        return sPref.setNickname("")
    }

    fun getMessagesData() = repository.getMessages()

    fun setMessageList(messages: List<Message>) {
        messageListLiveData.value = ArrayList(messages)
    }

    fun sendMessage(message: String) {

        messageLiveData.value = Message(
            "message_id",
            "${message}",
            Calendar.getInstance(Locale.getDefault()).timeInMillis,
            user = User("https://randomuser.me/api/portraits/men/78.jpg", "userID", "${nickname}")
        )
    }

    fun checkMessageView(message: String) {
        messageButtonStateLiveData.value = message.isNotEmpty()
    }
}