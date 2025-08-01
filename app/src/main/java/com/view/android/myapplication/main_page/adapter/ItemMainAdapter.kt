package com.view.android.myapplication.main_page.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.view.android.myapplication.component.model.Product
import com.view.android.myapplication.core.base.adapter.BaseAdapter
import com.view.android.myapplication.databinding.ItemViewholderMainBinding
import com.view.android.myapplication.main_page.view_holder.ItemMainViewHolder

class ItemMainAdapter : BaseAdapter<Product, ItemViewholderMainBinding, ItemMainViewHolder>() {
    var onItemClick: (Product) -> Unit = {}

    override fun inflateViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ): ItemViewholderMainBinding {
        return ItemViewholderMainBinding.inflate(layoutInflater)
    }

    override fun createViewHolder(binding: ItemViewholderMainBinding): ItemMainViewHolder {
        return ItemMainViewHolder(binding)
    }

    override fun onBind(holder: ItemMainViewHolder, item: Product, position: Int) {
        holder.bind(items[position])
        holder.view.tvTitle.setOnClickListener {
            onItemClick(items[position])
        }
    }


}