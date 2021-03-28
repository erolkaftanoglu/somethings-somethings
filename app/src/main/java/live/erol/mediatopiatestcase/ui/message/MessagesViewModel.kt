package live.erol.mediatopiatestcase.ui.message

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import live.erol.mediatopiatestcase.utils.SPref
import javax.inject.Inject

@HiltViewModel
class MessagesViewModel @Inject constructor(private val sPref: SPref) : ViewModel() {
    private var nicknameLiveData = MutableLiveData<String>()

    fun listenNickname() = nicknameLiveData

    fun getNickname() {
        val nickname = sPref.getNickname()
        nicknameLiveData.value = "$nickname"
    }

}