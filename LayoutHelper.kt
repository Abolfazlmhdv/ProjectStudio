/*
ID TELEGRAM : @mhdvia
*/


package Animation
import Animation.AndroidUtilities.dp

import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView

object LayoutHelper {

   const val MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT
    const val WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT

    fun createFrame(width: Int, height: Int, gravity: Int = Gravity.NO_GRAVITY, leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int): FrameLayout.LayoutParams {
        val parmsframe = FrameLayout.LayoutParams(dp(width), dp(height))
        parmsframe.setMargins(
            AndroidUtilities.dp(leftMargin), AndroidUtilities.dp(topMargin),
            AndroidUtilities.dp(rightMargin), AndroidUtilities.dp(bottomMargin)
        )
        parmsframe.gravity = gravity
        return parmsframe
    }
    fun createLinear(width: Int, height: Int, gravity: Int = Gravity.NO_GRAVITY, leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int): LinearLayout.LayoutParams {
      val parms = LinearLayout.LayoutParams(dp(width), dp(height))
        parms.gravity = gravity
        parms.setMargins(AndroidUtilities.dp(leftMargin), AndroidUtilities.dp(topMargin), AndroidUtilities.dp(rightMargin), AndroidUtilities.dp(bottomMargin))
        return parms
    }
    fun createText(width: Int, height: Int, gravity: Int = Gravity.NO_GRAVITY, leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int): LinearLayout.LayoutParams {
        val parmstext = LinearLayout.LayoutParams(dp(width), dp(height))
        parmstext.setMargins(dp(leftMargin),dp(topMargin),dp(rightMargin),bottomMargin)
        parmstext.gravity = gravity
        return parmstext
    }

    fun createImage(width: Int, height: Int, gravity: Int = Gravity.NO_GRAVITY, leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int) : LinearLayout.LayoutParams {
        val parmsImage = LinearLayout.LayoutParams(dp(width), dp(height))
        parmsImage.setMargins(dp(leftMargin),dp(topMargin),dp(rightMargin),dp(bottomMargin))
        parmsImage.gravity = gravity
        return parmsImage
    }

    fun createScroll(width: Int, height: Int, gravity: Int = Gravity.NO_GRAVITY, leftMargin: Int, topMargin: Int, rightMargin: Int, bottomMargin: Int) : LinearLayout.LayoutParams {
        val parmsScroll = LinearLayout.LayoutParams(dp(width), dp(height))
        parmsScroll.setMargins(dp(leftMargin), dp(topMargin), dp(rightMargin), dp(bottomMargin))
        parmsScroll.gravity = gravity
        return parmsScroll
    }
}
