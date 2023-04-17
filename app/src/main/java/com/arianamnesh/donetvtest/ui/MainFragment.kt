package com.arianamnesh.donetvtest.ui;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arianamnesh.donetvtest.R
import com.arianamnesh.donetvtest.commons.Utils
import com.arianamnesh.donetvtest.databinding.FragmentMainBinding

class MainFragment : Fragment() {

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
            Utils().showToast(requireContext(), "Hi")
        }
    }

    private fun setupUIElements() {
        binding.titleTv.text = "دان\u200Cتی\u200Cوی"
    }

    private fun loadRows() {

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
