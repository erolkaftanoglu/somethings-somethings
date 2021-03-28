package live.erol.testcase

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import live.erol.testcase.utils.Logger
import live.erol.testcase.utils.SPref
import javax.inject.Inject

@HiltAndroidApp
class MTApp : Application() {

    @Inject
    lateinit var sPref: SPref

    @Inject
    lateinit var logger: Logger

    override fun onCreate() {
        super.onCreate()
        logger.config()
        sPref.config(this)
    }
}