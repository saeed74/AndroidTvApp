package com.arianamnesh.donetvtest.ui;

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Slide
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.arianamnesh.donetvtest.R
import com.arianamnesh.donetvtest.adapters.MoviesAdapter
import com.arianamnesh.donetvtest.commons.Utils
import com.arianamnesh.donetvtest.databinding.FragmentMainBinding
import com.arianamnesh.donetvtest.databinding.RowItemBinding
import com.arianamnesh.donetvtest.model.Movie


class MainFragment : Fragment(), MoviesAdapter.OnItemClickListener,MoviesAdapter.OnRowFocused {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        setupUIElements()
        loadRows()
        setupClickListeners()
        return binding.root
    }

    private fun setupClickListeners() {
        binding.searchButton.setOnClickListener {
            Utils().showToast(requireContext(), "Search Button Clicked!")
        }
    }

    private fun setupUIElements() {
        binding.titleTv.text = "دان\u200Cتی\u200Cوی"
        binding.searchButton.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                val anim = AnimationUtils.loadAnimation(context, R.anim.scale_in)
                binding.searchButton.startAnimation(anim)
                anim.fillAfter = true
            } else {
                val anim = AnimationUtils.loadAnimation(context, R.anim.scale_out)
                binding.searchButton.startAnimation(anim)
                anim.fillAfter = true
            }
        }
    }

    private fun loadRows() {

        for (i in 1..3) {

            val inflater = LayoutInflater.from(context)
            val rowView = inflater.inflate(R.layout.row_item, binding.rowsContainer, false)
            val rowBinding = RowItemBinding.bind(rowView)
            rowBinding.rowTitle.text = getCategoryNameById(i)
            rowBinding.recyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val movies = mutableListOf<Movie>()
            for (j in 1..5){
                val movieId = (i * 10 + j).toLong()
                val movie = Movie(movieId, getMovieResById(movieId))
                movies.add(movie)
            }
            val adapter = MoviesAdapter(i,requireContext(),movies)

            adapter.setOnItemClickListener(this)
            adapter.setOnRowsFocusListener(this)

            rowBinding.recyclerview.adapter = adapter
            binding.rowsContainer.addView(rowView)

        }

    }

    override fun onItemClick(movie: Movie, position: Int) {
        Utils().showToast(requireContext(), "movie clicked: ${movie.id}")
    }

    override fun onFocused(rowPosition: Int) {
        val transition: Transition = Slide(Gravity.TOP)
        transition.duration = 300
        transition.addTarget(R.id.titleView)
        TransitionManager.beginDelayedTransition(binding.constraint, transition)

        if(rowPosition >= 2){
           binding.titleView.visibility = View.GONE;
        }else{
            binding.titleView.visibility = View.VISIBLE;
        }
    }

    private fun getMovieResById(id: Long): Int {
        when (id.toInt()){
            11 -> return R.drawable.movie11
            12 -> return R.drawable.movie12
            13 -> return R.drawable.movie13
            14 -> return R.drawable.movie14
            15 -> return R.drawable.movie15
            21 -> return R.drawable.movie21
            22 -> return R.drawable.movie22
            23 -> return R.drawable.movie23
            24 -> return R.drawable.movie24
            25 -> return R.drawable.movie25
            31 -> return R.drawable.movie31
            32 -> return R.drawable.movie32
            33 -> return R.drawable.movie33
            34 -> return R.drawable.movie34
            35 -> return R.drawable.movie35
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
