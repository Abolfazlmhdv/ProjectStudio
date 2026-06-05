package com.example.canvasapp
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.view.updateLayoutParams

import com.example.canvasapp.AndroidUtilites.dp

@SuppressLint("ViewConstructor")
class PopupView(context: Context) : FrameLayout(context) {

    init { content() }

    private fun content() {
        val frameButton = FrameLayout(context).apply {
            val radius = GradientDrawable().apply {
                cornerRadius = 8f
                setColor(Color.RED)
            }
            background = radius
        }
        addView(frameButton)


        val text = TextView(context).apply {
            setText("Click")
            setTextColor(Color.parseColor("#ffffff"))
            setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15f)
        }
        frameButton.addView(text)

        frameButton.setOnClickListener{view ->
            val drawable = frameButton.background as GradientDrawable
            text.text = ""

            val width = ValueAnimator.ofInt(width, dp(50)).apply {
                addUpdateListener{
                    val width = it.animatedValue as Int
                    frameButton.updateLayoutParams { this.width = width }
                }
            }

            val radius = ValueAnimator.ofInt(8,25).apply {
                addUpdateListener{
                 drawable.cornerRadius = it.animatedValue as Float
                }
            }
            val color = ValueAnimator.ofArgb(Color.RED, Color.BLACK).apply {
                addUpdateListener{
                    val color = it.animatedValue as Int
                    drawable.setColor(color)
                }

            }
            AnimatorSet().apply {
                playTogether(width, radius, color)
                duration = 400
                start()
            }
        }
    }



}
