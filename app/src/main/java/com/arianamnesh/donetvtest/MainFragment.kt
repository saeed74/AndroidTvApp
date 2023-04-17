package com.arianamnesh.donetvtest;

import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*


class MainFragment : BrowseSupportFragment() {

    private var _rowsAdapter: ArrayObjectAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUIElements()
        loadRows()
    }

    private fun setupUIElements() {

        headersState = HEADERS_HIDDEN

        title = "سلام"

        isHeadersTransitionOnBackEnabled = true

        brandColor = getColor(R.color.fastlane_background)

        setHeaderPresenterSelector(object : PresenterSelector() {
            override fun getPresenter(o: Any): Presenter {
                return MyRowHeaderPresenter()
            }
        })

    }

    private fun loadRows() {

        val listRowPresenter = MyListRowPresenter()
        _rowsAdapter = ArrayObjectAdapter(listRowPresenter)

        for (i in 1..3) {

            val gridItemPresenterHeader = HeaderItem(i.toLong(), "موضوع شماره " + i)

            val gridPresenter = MoviePresenter()
            val gridRowAdapter = ArrayObjectAdapter(gridPresenter)

            for (j in 1..5) {
                val movieId = (i * 10 + j).toLong()
                val movie = Movie(movieId,R.drawable.movie)
                gridRowAdapter.add(movie)
            }

            (_rowsAdapter as ArrayObjectAdapter).add(ListRow(gridItemPresenterHeader, gridRowAdapter))
        }

        adapter = _rowsAdapter
    }

    private fun getColor(colorId: Int): Int {
        return resources.getColor(colorId)
    }


}
