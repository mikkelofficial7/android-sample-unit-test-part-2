package com.view.android.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.view.android.myapplication.core.base.ext.loadFragment
import com.view.android.myapplication.databinding.ActivityMainBinding
import com.view.android.myapplication.main_page.fragment.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadView()
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (count < 2) finish() else super.onBackPressed()
    }

    private fun loadView() {
        loadFragment(MainFragment::class)
    }
}