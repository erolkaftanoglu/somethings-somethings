package live.erol.mediatopiatestcase.utils

import timber.log.Timber
import javax.inject.Inject

class Logger @Inject constructor() {

    fun config() = Timber.plant(Timber.DebugTree())

    fun log(message: String) = Timber.d(message)
    fun log(tag: String = "Majes", message: String) = Timber.tag(tag).d(message)
}