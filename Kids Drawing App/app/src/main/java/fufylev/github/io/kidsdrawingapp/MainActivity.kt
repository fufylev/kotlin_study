package fufylev.github.io.kidsdrawingapp

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity() {

    private var drawingView: DrawingView? = null
    private var mImageBtnCurrentPaint: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingView = findViewById(R.id.drawing_view)
        drawingView?.setSizeForBrush(10.toFloat())

        val linearLayoutPainColors = findViewById<LinearLayout>(R.id.ll_color_paint)
        mImageBtnCurrentPaint = linearLayoutPainColors[1] as ImageButton
        mImageBtnCurrentPaint!!.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.pallet_pressed
            )
        )

        val brushBtn: ImageButton = findViewById(R.id.ib_brush)
        brushBtn.setOnClickListener {
            showBrushSizeChoiceDialog()
        }
    }

    private fun showBrushSizeChoiceDialog() {
        val brushDialog = Dialog(this)

        brushDialog.setContentView(R.layout.dialog_brash_size)
        brushDialog.setTitle("Brush size")

        val smallBtn: ImageButton = brushDialog.findViewById(R.id.id_small_brush)
        smallBtn.setOnClickListener {
            drawingView?.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }

        val mediumBtn: ImageButton = brushDialog.findViewById(R.id.id_medium_brush)
        mediumBtn.setOnClickListener {
            drawingView?.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }

        val bigBtn: ImageButton = brushDialog.findViewById(R.id.id_big_brush)
        bigBtn.setOnClickListener {
            drawingView?.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }

        brushDialog.show()
    }

    fun paintClick(view: View) {
        println("paintClick")
        if (view !== mImageBtnCurrentPaint) {
            val imageBtn = view as ImageButton
            val tag = imageBtn.tag.toString()

            drawingView?.setColor(tag)

            imageBtn.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.pallet_pressed
                )
            )
            mImageBtnCurrentPaint?.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.pallet_normal
                )
            )

            mImageBtnCurrentPaint = view
        }
    }
}