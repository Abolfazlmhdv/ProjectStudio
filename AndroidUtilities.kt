package Animation

import android.content.res.Resources

object AndroidUtilities {

    fun dp(value: Number): Int {
        val density = Resources.getSystem().displayMetrics.density
        return (value.toFloat() * density + 0.5).toInt()
    }

    fun sp(value: Number): Int {
        val density = Resources.getSystem().displayMetrics.density
        return (value.toFloat() * density + 0.5).toInt()
    }


}
