package com.arianamnesh.donetvtest

import android.content.Context
import android.graphics.Point
import android.view.WindowManager
import android.widget.Toast
import java.lang.StringBuilder
import kotlin.math.roundToInt

class Utils {

    fun showLongToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun showLongToast(context: Context, resourceId: Int) {
        showLongToast(context, context.getString(resourceId))
    }

    fun convertDpToPixel(context: Context, dp: Int): Int {
        val density = context.resources.displayMetrics.density
        return (dp * density).roundToInt()
    }

}