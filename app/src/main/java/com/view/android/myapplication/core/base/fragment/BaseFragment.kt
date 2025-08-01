package com.view.android.myapplication.core.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding> : Fragment() {
    internal lateinit var binding: VB

    abstract fun layoutInflater(layoutInflater: LayoutInflater, parent: ViewGroup?, attachToParent: Boolean): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = layoutInflater(layoutInflater, container, false)
        return binding.root
    }
}