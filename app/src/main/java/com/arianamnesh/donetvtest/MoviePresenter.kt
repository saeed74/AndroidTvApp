package com.arianamnesh.donetvtest

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.ImageViewCompat
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter

class MoviePresenter : Presenter() {

    private val imgWidth = 150 //dp
    private val imgHeight = 200 //dp

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {

        context = parent?.context

        val imgView = ImageView(context)
        imgView.isFocusableInTouchMode = true

        imgView.adjustViewBounds = true
        imgView.scaleType = ImageView.ScaleType.CENTER_CROP;

        return ViewHolder(imgView)
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder?, item: Any?) {
        val movie = item as Movie
        (viewHolder as ViewHolder)!!.useMovie(movie)
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder?) {}

    inner class ViewHolder(view: View) : Presenter.ViewHolder(view) {

        val imgView = view as ImageView
        private var movie: Movie? = null

        fun useMovie(movie: Movie) {
            this.movie = movie
            val defaultCardImage = ResourcesCompat.getDrawable(context!!.resources, movie.img, context?.theme)
            imgView.layoutParams.height = Utils().convertDpToPixel(context!!,imgHeight)
            imgView.layoutParams.width = Utils().convertDpToPixel(context!!,imgWidth)
            imgView.requestLayout()
            imgView.setImageDrawable(defaultCardImage)
        }
    }
}