package com.view.android.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.view.android.myapplication.databinding.ActivityMainBinding
import com.view.android.myapplication.main_page.fragment.MainFragment
import kotlin.reflect.KClass

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

    fun loadFragment(fragment: KClass<out Fragment>, isAddToBackStack: Boolean = true, bundle: Bundle? = null) {
        val findFragment = supportFragmentManager.findFragmentByTag(fragment.simpleName)
        val fragmentToShow = findFragment ?: fragment.java.getDeclaredConstructor().newInstance()
        bundle?.let {
            fragmentToShow.arguments = it
        }

        supportFragmentManager.commit {
            if (isAddToBackStack) addToBackStack(fragment.simpleName)
            replace(R.id.frame_layout, fragmentToShow, fragment.simpleName)
        }
    }
}