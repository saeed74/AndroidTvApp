package com.arianamnesh.donetvtest.ui;

import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import com.arianamnesh.donetvtest.R
import com.arianamnesh.donetvtest.customviews.CustomListRowPresenter
import com.arianamnesh.donetvtest.customviews.CustomMoviePresenter
import com.arianamnesh.donetvtest.customviews.CustomRowHeaderPresenter
import com.arianamnesh.donetvtest.model.Movie


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

        title = "دان\u200Cتی\u200Cوی"

        isHeadersTransitionOnBackEnabled = true

        brandColor = getColor(R.color.fastlane_background)

        setHeaderPresenterSelector(object : PresenterSelector() {
            override fun getPresenter(o: Any): Presenter {
                return CustomRowHeaderPresenter()
            }
        })

    }

    private fun loadRows() {

        val listRowPresenter = CustomListRowPresenter()
        _rowsAdapter = ArrayObjectAdapter(listRowPresenter)

        for (i in 1..3) {

            val gridItemPresenterHeader = HeaderItem(i.toLong(),getCategoryNameById(i))

            val gridPresenter = CustomMoviePresenter()
            val gridRowAdapter = ArrayObjectAdapter(gridPresenter)

            for (j in 1..5) {
                val movieId = (i * 10 + j).toLong()
                val movie = Movie(movieId, getMovieResById(j))
                gridRowAdapter.add(movie)
            }

            (_rowsAdapter as ArrayObjectAdapter).add(ListRow(gridItemPresenterHeader, gridRowAdapter))
        }

        adapter = _rowsAdapter
    }

    private fun getMovieResById(id: Int): Int {
        when (id){
            1 -> return R.drawable.movie1
            2 -> return R.drawable.movie2
            3 -> return R.drawable.movie3
            4 -> return R.drawable.movie4
            5 -> return R.drawable.movie5
        }
        return R.drawable.movie
    }

    private fun getCategoryNameById(id: Int): String {
        when (id){
            1 -> return "فیلم\u200Cهای جدید"
            2 -> return "سریال\u200Cهای جنایی"
            3 -> return "فیلم\u200Cهای مستند"
        }
        return "unknown subject"
    }

    private fun getColor(colorId: Int): Int {
        return resources.getColor(colorId)
    }


}
