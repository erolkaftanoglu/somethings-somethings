package live.erol.mediatopiatestcase.ui.nickname

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import live.erol.mediatopiatestcase.utils.SPref
import javax.inject.Inject

@HiltViewModel
class NicknameViewModel @Inject constructor(private val sPref: SPref) : ViewModel() {

    private var buttonStateLiveData = MutableLiveData<Boolean>()
    private var nickname: String = ""

    fun listenButtonState(): LiveData<Boolean> = buttonStateLiveData

    fun setNickname(nickname: String) {
        buttonStateLiveData.value = nickname.length > 3
        this.nickname = nickname
    }


    fun letsContinueWithNickname(nickname: String): Boolean {
        if (nickname.length < 3) {
            return false
        }
        return sPref.setNickname(nickname = nickname)
    }
}