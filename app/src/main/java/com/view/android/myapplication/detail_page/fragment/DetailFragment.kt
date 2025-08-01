package com.view.android.myapplication.detail_page.fragment

import android.os.Bundle
import android.view.View
import com.view.android.myapplication.databinding.FragmentDetailBinding
import com.view.android.myapplication.core.base.fragment.BaseFragment

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {
    private val productTitle by lazy {
        arguments?.getString("product_title") ?: ""
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvContent.text = productTitle
    }
}