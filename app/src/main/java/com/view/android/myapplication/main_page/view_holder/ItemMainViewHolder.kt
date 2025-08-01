package com.view.android.myapplication.main_page.view_holder

import androidx.recyclerview.widget.RecyclerView
import com.view.android.myapplication.component.model.Product
import com.view.android.myapplication.databinding.ItemViewholderMainBinding

class ItemMainViewHolder(val view: ItemViewholderMainBinding) : RecyclerView.ViewHolder(view.root) {
    fun bind(item: Product) {
        view.tvTitle.text = item.title
    }
}