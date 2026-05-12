
/*
ID TELEGRAM : @mhdvia
*/


package ui
import Animation.AndroidUtilities.dp
import Animation.AndroidUtilities.sp
import Animation.AndroidUtilities.showtoast

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import Animation.LayoutHelper
import android.media.Image
import android.text.Layout
import android.view.View
import androidx.core.widget.NestedScrollView
import canvas.CircleImage
import com.example.animationapp.R

class ScrollAnimator(context: Context) : FrameLayout(context) {

        init {
            addView()
        }

        fun addView(){
                val layout = FrameLayout(context)
                layout.setBackgroundColor(Color.parseColor("#fff"))
                layout.fitsSystemWindows = true
                addView(layout, LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, LayoutHelper.MATCH_PARENT,
                        Gravity.FILL, 0,0,0,0
                ))


                val lineartitle = LinearLayout(context)
                lineartitle.orientation = LinearLayout.VERTICAL
                lineartitle.setBackgroundColor(Color.RED)
                layout.addView(lineartitle, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,250,
                        Gravity.CENTER_VERTICAL, 0,0,0,0
                ))

                val imageIcon = CircleImage(context)
                imageIcon.setImageResource(R.drawable.ic_launcher_background)
                imageIcon.scaleType = ImageView.ScaleType.CENTER_CROP
                lineartitle.addView(imageIcon, LayoutHelper.createImage(56, 56, Gravity.CENTER, 0,0,0,0))

                val titletext = TextView(context)
                titletext.setText(context.getString(R.string.app_name))
                titletext.setTextColor(Color.parseColor("#fff"))
                titletext.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, sp(17).toFloat())
                titletext.setTypeface(null, android.graphics.Typeface.BOLD)
                titletext.maxWidth = dp(250)
                lineartitle.addView(titletext, LayoutHelper.createText(LayoutHelper.WRAP_CONTENT,
                        LayoutHelper.WRAP_CONTENT, Gravity.CENTER, 0, 5,0,5
                ))

                val statustext = TextView(context)
                statustext.setText(context.getString(R.string.status))
                statustext.maxWidth = dp(250)
                statustext.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, sp(12).toFloat())
                statustext.setTextColor(Color.parseColor("#fff"))
                lineartitle.addView(statustext, LayoutHelper.createText(LayoutHelper.WRAP_CONTENT,
                        LayoutHelper.WRAP_CONTENT, Gravity.CENTER, 0, 3 ,0,0
                ))



                val scrollView = NestedScrollView(context)
                layout.addView(scrollView, LayoutHelper.createScroll(LayoutHelper.MATCH_PARENT,
                        LayoutHelper.MATCH_PARENT, Gravity.CENTER, 0,250,0,0
                ))


                val linear2 = LinearLayout(context)
                linear2.orientation = LinearLayout.VERTICAL
                linear2.setBackgroundColor(Color.WHITE)
                scrollView.addView(linear2, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,
                        LayoutHelper.MATCH_PARENT, Gravity.TOP, 0,0,0,0
                ))



                val captiontext = TextView(context)
                captiontext.setText(context.getString(R.string.msg))
                captiontext.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, sp(14).toFloat())
                captiontext.setPadding(dp(14),dp(14),dp(14),dp(14))
                captiontext.setTextColor(Color.parseColor("#000"))
                linear2.addView(captiontext, LayoutHelper.createText(LayoutHelper.MATCH_PARENT,
                        LayoutHelper.MATCH_PARENT, Gravity.CENTER_VERTICAL, 0,0,0,0
                ))

                captiontext.setOnClickListener{v ->
                        showtoast(context,"hello world")
                }

                lineartitle.pivotY = lineartitle.height.toFloat()
                scrollView.pivotY = scrollView.height.toFloat()

                scrollView.viewTreeObserver.addOnScrollChangedListener{
                        val scroll = scrollView.scrollY.toFloat()
                        val max = 320
                        val view = (scroll / max).coerceIn(0f,1f)

                       lineartitle.translationY = view * -320f
                        lineartitle.setPadding(dp(0),dp(0),dp(0),dp(10))
                        titletext.translationX = view * -200f
                        titletext.maxWidth = dp(250)
                        titletext.translationY = view * 100f

                        statustext.translationX = view * -200f
                        statustext.translationY = view * 90f
                        statustext.maxWidth = dp(250)


                        imageIcon.translationY = view * -150
                        val startAlpha = 1f
                        val EndAlpha = 0f

                        imageIcon.alpha = startAlpha - (startAlpha - EndAlpha) * view
                        val startScale = 1f
                        val endScale = 0.1f
                        val scale = startScale - (startScale - endScale) * view

                        imageIcon.scaleX = scale
                        imageIcon.scaleY = scale
                }
        }
}
