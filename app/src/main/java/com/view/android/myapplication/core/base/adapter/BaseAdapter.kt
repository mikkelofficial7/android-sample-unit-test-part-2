package com.view.android.myapplication.core.base.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T: Any, VB : ViewBinding, VH : RecyclerView.ViewHolder>: RecyclerView.Adapter<VH>()  {
    var items: List<T> = listOf()

    abstract fun inflateViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean): VB

    abstract fun createViewHolder(binding: VB): VH

    abstract fun onBind(holder: VH, item: T, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = inflateViewHolder(LayoutInflater.from(parent.context), parent, false)
        return createViewHolder(binding)
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