package com.view.android.myapplication.core.ext

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.view.android.myapplication.MainActivity
import com.view.android.myapplication.R
import kotlin.reflect.KClass

fun Activity.navigateTo(fragment: KClass<out Fragment>) {
    (this as MainActivity).loadFragment(fragment)
}

fun Activity.navigateTo(fragment: KClass<out Fragment>, isAddBackStack: Boolean = true) {
    (this as MainActivity).loadFragment(fragment, isAddToBackStack = isAddBackStack)
}

fun Activity.navigateTo(fragment: KClass<out Fragment>, isAddBackStack: Boolean = true, bundle: Bundle? = null) {
    (this as MainActivity).loadFragment(fragment, isAddBackStack, bundle)
}

fun FragmentActivity.loadFragment(
    fragment: KClass<out Fragment>,
    isAddToBackStack: Boolean = true,
    bundle: Bundle? = null
) {
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