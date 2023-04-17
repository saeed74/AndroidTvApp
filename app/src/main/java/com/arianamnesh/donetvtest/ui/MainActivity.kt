package com.arianamnesh.donetvtest.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.arianamnesh.donetvtest.R

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment()
    }
    private fun loadFragment() {
        val myFragment = MainFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_browse_fragment, myFragment)
            .commit()
    }
}
