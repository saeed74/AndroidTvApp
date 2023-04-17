package com.arianamnesh.donetvtest.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.arianamnesh.donetvtest.R
import com.arianamnesh.donetvtest.model.Movie

class MoviesAdapter(val rowId: Int, val context: Context, val movies: List<Movie>) :
    RecyclerView.Adapter<MoviesAdapter.ImageViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(movie: Movie, position: Int)
    }
    interface OnRowFocused {
        fun onFocused(rowPosition: Int)
    }
    private var clickListener: OnItemClickListener? = null
    private var focusListener: OnRowFocused? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.imageView.setImageResource(movies[position].img)
        holder.root.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                focusListener?.onFocused(rowId)
                val anim = AnimationUtils.loadAnimation(context, R.anim.scale_in)
                holder.root.startAnimation(anim)
                anim.fillAfter = true
            } else {
                val anim = AnimationUtils.loadAnimation(context, R.anim.scale_out)
                holder.root.startAnimation(anim)
                anim.fillAfter = true
            }
        }
        holder.root.setOnClickListener {
            clickListener?.onItemClick(movies[position],position)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val root: View = itemView
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.clickListener = listener
    }

    fun setOnRowsFocusListener(listener: OnRowFocused) {
        this.focusListener = listener
    }
}