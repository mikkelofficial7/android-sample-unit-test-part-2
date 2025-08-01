package com.view.android.myapplication.core.base.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

open class BaseAdapter<T: Any, VB : ViewBinding, VH : RecyclerView.ViewHolder>(
    private val bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> VB,
    private val viewHolderFactory: (VB) -> VH,
    private val onBind: (VH, T, Int) -> Unit = {_, _, _ -> }
) : RecyclerView.Adapter<VH>()  {
    var items: List<T> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = bindingInflater(LayoutInflater.from(parent.context), parent, false)
        return viewHolderFactory(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        onBind(holder, items[position], position)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<T>) {
        items = newList
        notifyDataSetChanged()
    }
}