package com.example.app.ViewActivitys

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.widget.NestedScrollView
import com.example.app.R

@SuppressLint("SetTextI18n", "ClickableViewAccessibility")
class ScrollAnimitor(context: Context) : FrameLayout(context) {

    private val imageView: ImageView
    private val textView: TextView
    private val linearlayout: LinearLayout
    private val scrollView: NestedScrollView
    private lateinit var  text_online: TextView


    init {

        val activity = context as Activity
        activity.window.statusBarColor = Color.parseColor("#891414")
        WindowInsetsControllerCompat(activity.window, activity.window.decorView)
            .isAppearanceLightStatusBars = false

        LayoutInflater.from(context).inflate(R.layout.page_view1, this, true)

        imageView = findViewById(R.id.imageview)
        textView = findViewById(R.id.textview)
        linearlayout = findViewById(R.id.linearlayout)
        text_online = findViewById(R.id.text_online)
        scrollView = findViewById(R.id.scrollview)

        textView.text = "Abolfazl Mahdavi"
        textView.setTextSize(12f)
        textView.setTextColor(Color.WHITE)

        text_online.text = "online"
        text_online.setTextColor(Color.LTGRAY)
        text_online.setTextSize(10f)

        linearlayout.pivotY = linearlayout.height.toFloat()
        scrollView.pivotY = scrollView.height.toFloat()



        scrollView.viewTreeObserver.addOnScrollChangedListener{
            val scroll = scrollView.scrollY.toFloat()
            val max = 320f
            val Lirogram = (scroll / max).coerceIn(0f,1f)


            linearlayout.translationY = Lirogram * -320f
            linearlayout.setPadding(0,0,0,10)
            textView.setTextSize(12f)
            textView.translationX = Lirogram * -200f
            textView.translationY = Lirogram * 100f
            textView.setPadding(25,0,0,0)

            text_online.translationX = Lirogram * -200f
            text_online.translationY = Lirogram * 90f


            imageView.translationY = Lirogram * -150
            val startAlpha = 1f
            val endAlpha = 0f

            imageView.alpha = startAlpha - (startAlpha - endAlpha) * Lirogram

            val startScale = 1f
            val endScale = 0.1f
            val scale = startScale - (startScale - endScale) * Lirogram

            imageView.scaleX = scale
            imageView.scaleY = scale

        }


    }
}
