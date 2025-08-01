package com.view.android.myapplication.main_page.adapter

import com.view.android.myapplication.component.model.Product
import com.view.android.myapplication.core.base.adapter.BaseAdapter
import com.view.android.myapplication.databinding.ItemViewholderMainBinding
import com.view.android.myapplication.main_page.view_holder.ItemMainViewHolder

class ItemMainAdapter : BaseAdapter<Product, ItemViewholderMainBinding, ItemMainViewHolder>(
        bindingInflater = ItemViewholderMainBinding::inflate,
        viewHolderFactory = { binding -> ItemMainViewHolder(binding) }
    ) {

    var onItemClick: (Product) -> Unit = {}

    override fun onBindViewHolder(holder: ItemMainViewHolder, position: Int) {
        holder.bind(items[position])
        holder.view.tvTitle.setOnClickListener {
            onItemClick(items[position])
        }
    }

}