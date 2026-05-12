/*
ID TELEGRAM : @mhdvia
*/

package canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class CircleImage @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : AppCompatImageView(context, attrs,defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()


    override fun onDraw(canvas: Canvas) {
        val radius = width.coerceAtMost(height) / 1.5f

        val x = width / 1.5f
        val y = height / 1.5f

        path.reset()
        path.addCircle(x,y,radius, Path.Direction.CW)
        canvas.clipPath(path)
        canvas.save()

        super.onDraw(canvas)
    }
}
