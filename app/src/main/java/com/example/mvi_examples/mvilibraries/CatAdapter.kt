package com.example.mvi_examples.mvilibraries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvi_examples.R
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation

class CatAdapter : ListAdapter<Cat, RecyclerView.ViewHolder>(CatDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_item, parent, false)
        return CatItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as CatItemViewHolder).bind(item)
    }

    inner class CatItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var catName: TextView = itemView.findViewById(R.id.catName)
        var catImage: ImageView = itemView.findViewById(R.id.catAvatar)

        fun bind(listItem: Cat) {
            catName.text = listItem.catName
            Picasso.get()
                .load(listItem.imageUrl)
                .resize(128, 128)
                .centerCrop()
                .transform(RoundedCornersTransformation(8, 8))
                .placeholder(R.drawable.ic_launcher_background)
                .into(catImage)
        }
    }
}