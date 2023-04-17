package com.arianamnesh.donetvtest.customviews

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.leanback.widget.TitleViewAdapter
import com.arianamnesh.donetvtest.R

class CustomTitleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0) : RelativeLayout(context, attrs, defStyle), TitleViewAdapter.Provider {

    private val mTitleView: TextView
    private val mAnalogClockView: View
    private val mImageView: ImageView
    private val mSearchOrbView: View

    init {
        val root = LayoutInflater.from(context).inflate(R.layout.custom_titleview, this)
        mTitleView = root.findViewById(R.id.title_tv)
        mAnalogClockView = root.findViewById(R.id.clock)
        mImageView = root.findViewById(R.id.img)
        mSearchOrbView = root.findViewById(R.id.search_orb)
    }

    private val mTitleViewAdapter: TitleViewAdapter = object : TitleViewAdapter() {
        override fun getSearchAffordanceView(): View {
            return mSearchOrbView
        }

        override fun setTitle(titleText: CharSequence?) {
            this@CustomTitleView.setTitle(titleText)
        }

        override fun setBadgeDrawable(drawable: Drawable?) {
            //CustomTitleView.this.setBadgeDrawable(drawable);
        }

        override fun setOnSearchClickedListener(listener: OnClickListener?) {
            mSearchOrbView.setOnClickListener(listener)
        }

        override fun updateComponentsVisibility(flags: Int) {
            val visibility =
                if (flags and SEARCH_VIEW_VISIBLE == SEARCH_VIEW_VISIBLE) VISIBLE else INVISIBLE
            mSearchOrbView.visibility = visibility
        }

        private fun updateBadgeVisibility(visible: Boolean) {
            if (visible) {
                mAnalogClockView.visibility = VISIBLE
                mTitleView.visibility = VISIBLE
            } else {
                mAnalogClockView.visibility = GONE
                mTitleView.visibility = GONE
            }
        }
    }

    fun setTitle(title: CharSequence?) {
        if (title != null) {
            mTitleView.text = title
            mTitleView.alpha = 1f
            mTitleView.visibility = VISIBLE
            mAnalogClockView.visibility = VISIBLE
            mImageView.visibility = VISIBLE
        }
    }

    fun setBadgeDrawable(drawable: Drawable?) {
        if (drawable != null) {
            mTitleView.visibility = GONE
            mAnalogClockView.visibility = VISIBLE
        }
    }

    override fun getTitleViewAdapter(): TitleViewAdapter {
        return mTitleViewAdapter
    }

}