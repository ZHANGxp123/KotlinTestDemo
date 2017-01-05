package com.ress.kotlindemo.decotaration

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ItemDecoration
import android.view.View

/**
 * Created by ress on 2017/1/3.
 */
class MainItemDecoration : ItemDecoration() {

    val paint = Paint()
    private var space: Int=0

    fun setSpace(space: Int) {
        this.space=space
    }

    private var height: Int=0

    fun setHeight(height: Int) {
        this.height=height
        paint.isAntiAlias=true
        paint.style=Paint.Style.FILL
        paint.color=Color.GRAY
    }


    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect?.top=space
        outRect?.left=space
    }

    override fun onDraw(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.onDraw(c, parent, state)
        val left = parent?.paddingLeft
        val right = parent?.measuredWidth?.minus(parent.paddingRight)
        val childCount = parent?.childCount
        for (i in 0..childCount as Int) {
            val view = parent?.getChildAt(i)
           // val layoutParams:RecyclerView.LayoutParams = view?.layoutParams as RecyclerView.LayoutParams
            val bottom = view?.bottom
            val top = bottom?.plus(height)
            c?.drawRect(left,top,right,bottom,paint)
        }
    }
}

private fun Canvas.drawRect(left: Int?, top: Int?, right: Int?, bottom: Int?, paint: Paint) {


}
