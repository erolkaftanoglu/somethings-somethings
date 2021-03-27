package live.erol.mediatopiatestcase.utils

import android.content.Context
import com.tencent.mmkv.MMKV
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SPref @Inject constructor() {
    private var kv: MMKV? = null
    val APP_TOKEN = "APP.TOKEN"

    fun config(@ApplicationContext context: Context) {
        MMKV.initialize(context)
        kv = MMKV.defaultMMKV()
    }

    private fun saveString(key: String, value: String) = kv?.encode(key, value)
    private fun getString(key: String, defaultValue: String): String =
        kv?.decodeString(key, defaultValue)!!

    fun getToken(): String? {
        return getString(APP_TOKEN, "")
    }

    fun setToken(token: String) {
        saveString(APP_TOKEN, token)
    }

}