package com.arianamnesh.donetvtest

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter

class CardPresenter : Presenter() {
    private val cardWidth = 300
    private val cardHeight = 350

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {

        context = parent?.context

        val cardView = ImageCardView(context)

        cardView.isFocusableInTouchMode = true

        if (context != null) {
            val backgroundColor = context!!.resources.getColor(R.color.fastlane_background, context!!.theme)

            cardView.setBackgroundColor(backgroundColor)
        }

        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder?, item: Any?) {

        val movie = item as Movie
        (viewHolder as ViewHolder)!!.useMovie(movie)

    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder?) {

    }

    inner class ViewHolder(view: View) : Presenter.ViewHolder(view) {
        val cardView = view as ImageCardView
        val defaultCardImage = context?.resources?.getDrawable(R.drawable.movie, context?.theme)

        private var movie: Movie? = null

        fun useMovie(movie: Movie) {
            this.movie = movie

            cardView.titleText = movie.title
            cardView.contentText = movie.studio

            cardView.setMainImageDimensions(cardWidth, cardHeight)
            cardView.mainImage = defaultCardImage
        }
    }
}