package com.arianamnesh.donetvtest.commons

import android.content.Context
import android.graphics.Point
import android.view.WindowManager
import android.widget.Toast
import java.lang.StringBuilder
import kotlin.math.roundToInt

class Utils {

    fun convertDpToPixel(context: Context, dp: Int): Int {
        val density = context.resources.displayMetrics.density
        return (dp * density).roundToInt()
    }

}