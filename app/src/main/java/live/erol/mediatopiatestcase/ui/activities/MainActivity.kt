package live.erol.mediatopiatestcase.ui.activities

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import live.erol.mediatopiatestcase.R
import live.erol.mediatopiatestcase.base.BaseActivity

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}