package com.arianamnesh.donetvtest;

import android.graphics.Color;
import android.os.Bundle
import android.util.Log;
import android.view.Gravity;
import android.view.View
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.leanback.app.BrowseFragment

import androidx.leanback.widget.*

private const val GRID_ITEM_WIDTH = 300
private const val GRID_ITEM_HEIGHT = 200

class MainFragment : BrowseFragment() {
    private val TAG = "MainFragment"
    private var _rowsAdapter: ArrayObjectAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val toastViewGroup = LayoutInflater.from(context).inflate(R.layout.custom_tite_view, null)
        //val textView: TextView = toastViewGroup.findViewById(R.id.title_tv)
        //textView.text = "The time is currently ${Calendar.getInstance().time}"
//        val toast = Toast(context)
//
//        toast.setGravity(Gravity.BOTTOM or Gravity.RIGHT, 0, 0)
//        toast.duration = Toast.LENGTH_LONG
//        toast.view = toastViewGroup
//        toast.show()

        Log.i(TAG, "onViewCreated")
        setupUIElements()
        loadRows()


    }

    private fun setupUIElements() {

        title = "my title!! is here"

//        val toastViewGroup = LayoutInflater.from(context).inflate(R.layout.custom_toast, null)
//        installTitleView(LayoutInflater.from(context),
//            toastViewGroup as ViewGroup?,b)

        //val toastViewGroup = LayoutInflater.from(context).inflate(R.layout.title_view, null)

        //val customTitleView = LayoutInflater.from(activity).inflate(R.layout.title_view, null) as RelativeLayout

        // Set the custom title view as the title view for the fragment
        //titleView = customTitleView


        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true

        brandColor = getColor(R.color.fastlane_background)
        searchAffordanceColor = getColor(R.color.search_opaque)
    }

    private fun loadRows() {
        _rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        for (i in 1..3) {
            val gridItemPresenterHeader = HeaderItem(i.toLong(), "Grid Item Presenter $i")

            val gridPresenter = CardPresenter()
            val gridRowAdapter = ArrayObjectAdapter(gridPresenter)

            for (j in 1..5) {
                val movieId = (i * 10 + j).toLong()
                val movie = Movie(
                    movieId,
                    "Title $movieId",
                    "Studio $movieId"
                )

                gridRowAdapter.add(movie)
            }

            (_rowsAdapter as ArrayObjectAdapter).add(ListRow(gridItemPresenterHeader, gridRowAdapter))
        }

        adapter = _rowsAdapter
    }

    private fun getColor(colorId: Int): Int {
        return resources.getColor(colorId)
    }

    private class GridItemPresenter : Presenter() {
        override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
            val view = TextView(parent.context)

            view.layoutParams = ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT)
            view.isFocusable = true
            view.isFocusableInTouchMode = true
            view.setBackgroundColor(Color.BLUE)
            view.setTextColor(Color.WHITE)
            view.gravity = Gravity.CENTER

            return ViewHolder(view)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
            (viewHolder.view as TextView)?.text = item?.toString()
        }

        override fun onUnbindViewHolder(viewHolder: ViewHolder) {

        }
    }

}