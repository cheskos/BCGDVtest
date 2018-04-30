package com.chisko.bcgdvtest.util

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView

class RecyclerDivider : RecyclerView.ItemDecoration {

    private var divider: Drawable? = null

    /**
     * Default divider will be used
     */
    constructor(context: Context) {
        val ATTRS = intArrayOf(android.R.attr.listDivider)
        val styledAttributes = context.obtainStyledAttributes(ATTRS)
        divider = styledAttributes.getDrawable(0)
        styledAttributes.recycle()
    }

    /**
     * Custom divider will be used
     */
    constructor(context: Context, resId: Int) {
        divider = ContextCompat.getDrawable(context, resId)
    }

    constructor(separator: Drawable) {
        this.divider = separator
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        val dividerLeft = parent.paddingLeft
        val dividerRight = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount - 1) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val dividerTop = child.bottom + params.bottomMargin
            val dividerBottom = dividerTop + divider!!.intrinsicHeight

            divider!!.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom)
            divider!!.draw(c)
        }
    }
}


