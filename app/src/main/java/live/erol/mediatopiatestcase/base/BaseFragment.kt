package live.erol.mediatopiatestcase.base

import android.widget.Toast
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {


    fun showError(error: String) {
        Toast.makeText(context, "$error", Toast.LENGTH_SHORT).show()
    }
}