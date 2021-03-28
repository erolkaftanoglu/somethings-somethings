package live.erol.testcase.extensions

import android.view.View
import live.erol.testcase.utils.SafeClickListener

fun View.showView() {
    visibility = View.VISIBLE
}

fun View.goneView() {
    visibility = View.GONE
}

fun View.hide() {
    visibility = View.INVISIBLE
}


fun View.setOnSafeClickListener(
    onSafeClick: (View) -> Unit
) {
    setOnClickListener(SafeClickListener { v ->
        onSafeClick(v)
    })
}

fun View.setOnSafeClickListener(
    interval: Int,
    onSafeClick: (View) -> Unit
) {
    setOnClickListener(SafeClickListener(interval) { v ->
        onSafeClick(v)
    })
}

