package com.example.shakil.kotlinfacedetect.Helper

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF

class RectOverlay internal constructor(overlay: GraphicOverlay, private val bound: Rect?) : GraphicOverlay.Graphic(overlay){

    private val RECT_COLOR = Color.RED
    private val STROKE_WIDTH = 4.0f
    private val rectPaint: Paint

    init {

        rectPaint = Paint()
        rectPaint.color = RECT_COLOR
        rectPaint.style = Paint.Style.STROKE
        rectPaint.strokeWidth = STROKE_WIDTH

        postInvalidate()
    }

    override fun draw(canvas: Canvas) {
        val rectF = RectF(bound)
        rectF.left = translateX(rectF.left)
        rectF.right = translateX(rectF.right)
        rectF.top = translateY(rectF.top)
        rectF.bottom = translateY(rectF.bottom)

        canvas.drawRect(rectF, rectPaint)
    }
}