package live.erol.testcase.ui.activities

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import live.erol.testcase.R
import live.erol.testcase.base.BaseActivity

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}