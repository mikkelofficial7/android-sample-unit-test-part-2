package com.view.android.myapplication.core.base.ext

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.view.android.myapplication.MainActivity
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