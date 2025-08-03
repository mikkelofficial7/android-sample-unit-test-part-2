package com.view.android.myapplication.main_page.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.view.android.myapplication.component.model.ProductResponse
import com.view.android.myapplication.component.viewmodel.MainViewModel
import com.view.android.myapplication.core.ext.navigateTo
import com.view.android.myapplication.core.base.fragment.BaseFragment
import com.view.android.myapplication.core.state.NetworkState
import com.view.android.myapplication.databinding.FragmentMainBinding
import com.view.android.myapplication.detail_page.fragment.DetailFragment
import com.view.android.myapplication.main_page.adapter.ItemMainAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding>() {
    private val mainViewModel: MainViewModel by viewModel()
    private val mainAdapter by lazy {
        ItemMainAdapter()
    }

    override fun createViewBinding(
        layoutInflater: LayoutInflater,
        parent: ViewGroup?,
        attachToParent: Boolean
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onViewReady() {
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mainAdapter
        }

        mainViewModel.loadAllProduct()
        mainViewModel.loadAllProductFromDb()

        mainAdapter.onItemClick = {
            val bundle = Bundle().apply { putString("product_title", it.title) }
            requireActivity().navigateTo(DetailFragment::class, bundle = bundle)
        }
    }

    override fun observeData() {
        mainViewModel.productData.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkState.Loading -> {
                    Toast.makeText(requireContext(), "Loading...", Toast.LENGTH_SHORT).show()
                }
                is NetworkState.Success<*> -> {
                    val response = it.result as ProductResponse
                    mainAdapter.updateData(response.products)
                }
                is NetworkState.Failed -> {
                    Toast.makeText(requireContext(), "API Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun observeViewModel() {

    }
}