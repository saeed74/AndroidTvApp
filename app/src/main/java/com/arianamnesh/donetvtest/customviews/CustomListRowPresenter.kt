package com.arianamnesh.donetvtest.customviews

import android.graphics.Color
import android.util.TypedValue
import androidx.core.content.res.ResourcesCompat
import androidx.leanback.widget.*
import com.arianamnesh.donetvtest.R


class CustomListRowPresenter : ListRowPresenter() {

    override fun onBindRowViewHolder(holder: RowPresenter.ViewHolder?, item: Any?) {
        super.onBindRowViewHolder(holder, item)
        val textView = holder?.headerViewHolder?.view?.findViewById<RowHeaderView>(R.id.row_header)
        textView?.run {
            setTextColor(Color.CYAN)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 14.5f)
            isAllCaps = true
            typeface = ResourcesCompat.getFont(context, R.font.yekan_bold)
        }
    }

}