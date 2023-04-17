package com.arianamnesh.donetvtest.customviews

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.RowHeaderPresenter
import com.arianamnesh.donetvtest.R

class CustomRowHeaderPresenter : RowHeaderPresenter() {
    private var mUnselectedAlpha = 0f
    override fun onCreateViewHolder(viewGroup: ViewGroup): ViewHolder {
        mUnselectedAlpha = viewGroup.resources
            .getFraction(R.fraction.lb_browse_header_unselect_alpha, 1, 1)
        val inflater = viewGroup.context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.custom_header_item, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, o: Any) {
        val iconHeaderItem: HeaderItem = (o as ListRow).headerItem as HeaderItem
        val rootView = viewHolder.view
        val label = rootView.findViewById<View>(R.id.header_label) as TextView
        label.text = iconHeaderItem.name
        label.setTextColor(Color.RED)
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) {
    }

}