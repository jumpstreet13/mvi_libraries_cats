package com.abocha.mvilibraries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.cat_item.view.*

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
        var catName: TextView = itemView.catName
        var catImage: ImageView = itemView.catAvatar

        fun bind(listItem: Cat) {
            catName.text = listItem.catName
            Picasso.get()
                .load(listItem.imageUrl)
                .resize(128, 128)
                .centerCrop()
                .transform(RoundedCornersTransformation(8, 8))
                .placeholder(R.drawable.ic_baseline_photo_size_select_actual_24)
                .into(catImage)
        }
    }
}