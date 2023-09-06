package com.example.nortaltesttask.ui.movieCategories.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nortaltesttask.R
import com.example.nortaltesttask.data.models.MovieCategory
import kotlinx.android.synthetic.main.list_item_categories.view.*

class CategoryAdapter : ListAdapter<MovieCategory, CategoryAdapter.ViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_categories, parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: MovieCategory) = with(itemView) {
            val imageView = findViewById<ImageView>(R.id.category)
            imageView.setImageResource(item.category)
        }
    }

    private class DiffUtilCallback : DiffUtil.ItemCallback<MovieCategory>() {

        override fun areItemsTheSame(
            oldItem: MovieCategory,
            newItem: MovieCategory,
        ): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: MovieCategory,
            newItem: MovieCategory,
        ): Boolean {
            return oldItem == newItem
        }
    }
}