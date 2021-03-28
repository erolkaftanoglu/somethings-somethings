package live.erol.testcase.ui.nickname

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import live.erol.testcase.utils.SPref
import javax.inject.Inject

@HiltViewModel
class NicknameViewModel @Inject constructor(private val sPref: SPref) : ViewModel() {

    private var buttonStateLiveData = MutableLiveData<Boolean>(false)
    private var nickname: String = ""

    fun listenButtonState(): LiveData<Boolean> = buttonStateLiveData

    fun setNickname(nickname: String) {
        buttonStateLiveData.value = nickname.length > 2
        this.nickname = nickname
    }

    fun letsContinueWithNickname(nickname: String): Boolean {
        return sPref.setNickname(nickname = nickname)
    }

    fun checkUserSession(): Boolean {
        if (sPref.getNickname().isNotEmpty())
            return true
        return false
    }
}