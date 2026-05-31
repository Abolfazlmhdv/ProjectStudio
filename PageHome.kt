package com.example.desginapp

import Desgins.AndroidUtilites.dp
import Desgins.AndroidUtilites.sp
import Desgins.Helper


import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.view.Gravity
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.view.setPadding
import com.google.android.material.bottomsheet.BottomSheetDialog

class PageHome(private val context: Context) : FrameLayout(context) {


    fun views() {
        val framelayout = FrameLayout(context)
        framelayout.setBackgroundColor(Color.WHITE)
        addView(framelayout, Helper.createFrame(Helper.MATH_PARENT, Helper.MATH_PARENT, Gravity.CENTER_HORIZONTAL, 0,0,0,0))

        val borderEditText = GradientDrawable().apply {
            cornerRadius = 8f
            setStroke(2, Color.parseColor("#000000"))
        }
        val edittext = EditText(context)
        edittext.setTextSize(TypedValue.COMPLEX_UNIT_PX, sp(15).toFloat())
        edittext.setHint(context.getString(R.string.msg))
        edittext.setHintTextColor(Color.parseColor("#000000"))
        edittext.setPadding(dp(8),dp(8),dp(8),dp(8))
        edittext.background = borderEditText
        framelayout.addView(edittext, Helper.createEditText(Helper.MATH_PARENT, Helper.WRAP_CONTENT,
            Gravity.START, 0,0,0,0
        ))
        val sendNote = ImageView(context)
        sendNote.setImageResource(R.drawable.ic_launcher_background)
        sendNote.setPadding(dp(8),dp(8),dp(8), dp(8))
        framelayout.addView(sendNote, Helper.createFrame(50,50, Gravity.END, 25,0,0,0))

        edittext.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(char: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(char: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.isNullOrEmpty()) {
                    sendNote.visibility = VISIBLE
                } else {
                    sendNote.visibility = GONE
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
        val frameClickEmoji = FrameLayout(context)
        val border = GradientDrawable()
        border.cornerRadius = 15f
        border.setColor(Color.BLACK)
        frameClickEmoji.background = border
        framelayout.addView(frameClickEmoji, Helper.createFrame(50,50, Gravity.CENTER, 25,0,0,0))

        frameClickEmoji.setOnClickListener{v ->
            val OpenSheet = BottomSheetDialog(context)
            OpenSheet.show()
        }
    }
}
