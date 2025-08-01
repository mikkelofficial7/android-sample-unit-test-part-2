package com.view.android.myapplication.detail_page.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.view.android.myapplication.databinding.FragmentDetailBinding
import com.view.android.myapplication.core.base.fragment.BaseFragment

class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    private val productTitle by lazy {
        arguments?.getString("product_title") ?: ""
    }

    override fun createViewBinding(
        layoutInflater: LayoutInflater,
        parent: ViewGroup?,
        attachToParent: Boolean
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(layoutInflater)
    }

    override fun onViewReady() {
        binding.tvContent.text = productTitle
    }

    override fun observeData() {
    }
}