package com.example.canvasapp
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import com.example.canvasapp.AndroidUtilites.dp
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout

class AddnoteView (context: Context) : LinearLayout(context) {


    init { addNote() ; orientation = VERTICAL }

    private fun addNote() {

        val topSection = LinearLayout(context).apply {
            orientation = HORIZONTAL
            setBackgroundColor(Color.WHITE)
        }
        addView(topSection, Helper.createLinear(Helper.MATCH_PARENT, Helper.WRAP_CONTENT, Gravity.CENTER, 0,0,0,0))

        val sendNote = ImageView(context).apply {
            setImageResource(R.drawable.ic_launcher_background)
            setPadding(dp(8), dp(8), dp(8), dp(8))
        }
        topSection.addView(sendNote, Helper.createLinear(width = 35, height = 35, Gravity.START, 10,0,0,0))


        val texttitle = EditText(context).apply {
            setHint(context.getString(R.string.title))
            setTextSize(TypedValue. COMPLEX_UNIT_DIP, 15f)
            setTextColor(Color.BLACK)
            setPadding(dp(8), dp(8), dp(8), dp(8))
            setHintTextColor(Color.parseColor("#eeeeee"))
        }
        topSection.addView(texttitle, Helper.createLinear(Helper.MATCH_PARENT, Helper.WRAP_CONTENT,
            Gravity.START, 0,0,0,0
        ))

        topSection.setOnClickListener{v ->
            val drawable = topSection.background as GradientDrawable
            val startHeight = topSection.height
            val endHeight =  dp(150)
            val heightLinear = ValueAnimator.ofInt(startHeight, endHeight).apply {
                addUpdateListener{animator ->
                    val value = animator.animatedValue as Int

                    topSection.layoutParams = topSection.layoutParams.apply {
                        height = value
                    }
                }
            }
            val radius = ValueAnimator.ofFloat(0f, 15f).apply {
                addUpdateListener { animator ->
                    val radius = animator.animatedValue as Float
                    val radii = floatArrayOf(
                        0f,0f,
                        0f,0f,
                        radius, radius,
                        radius, radius
                    )
                    drawable.cornerRadii = radii
                }
            }
            AnimatorSet().apply {
                playTogether(heightLinear, radius)
                setDuration(250)
                 start()
             }
        }
        val view = View(context).apply {
            setBackgroundColor(Color.parseColor("#e0e0e0"))
        }
        addView(view, Helper.createLinear(Helper.MATCH_PARENT, height = 50, Gravity.CENTER, 0,0,0,0))
    }
}
