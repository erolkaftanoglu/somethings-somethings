package live.erol.testcase.utils

import android.content.Context
import com.tencent.mmkv.MMKV
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SPref @Inject constructor() {
    private var kv: MMKV? = null
    val APP_NICKNAME = "APP.NICKNAME"

    fun config(@ApplicationContext context: Context) {
        MMKV.initialize(context)
        kv = MMKV.defaultMMKV()
    }

    private fun saveString(key: String, value: String) = kv?.encode(key, value) ?: false
    private fun getString(key: String, defaultValue: String): String =
        kv?.decodeString(key, defaultValue)!!

    fun getNickname(): String {
        return getString(APP_NICKNAME, "")
    }

    fun setNickname(nickname: String): Boolean {
        return saveString(APP_NICKNAME, nickname)
    }

}