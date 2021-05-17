package com.example.mvi_examples.mvilibraries

import androidx.recyclerview.widget.DiffUtil
import com.example.mvi_examples.mvilibraries.Cat

class CatDiffUtilCallback : DiffUtil.ItemCallback<Cat>() {

    override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem == newItem
    }
}