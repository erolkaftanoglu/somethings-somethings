package live.erol.mediatopiatestcase

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import live.erol.mediatopiatestcase.utils.SPref
import javax.inject.Inject

@HiltAndroidApp
class MTApp : Application() {

    @Inject
    lateinit var sPref: SPref

    override fun onCreate() {
        super.onCreate()
        sPref.config(this)
    }
}