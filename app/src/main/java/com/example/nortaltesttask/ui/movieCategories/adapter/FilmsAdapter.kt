package com.example.nortaltesttask.ui.movieCategories.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nortaltesttask.R
import com.example.nortaltesttask.data.models.Film
import kotlinx.android.synthetic.main.list_item_film.view.*

class FilmsAdapter : ListAdapter<Film, FilmsAdapter.ViewHolder>(
    DiffUtilCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_film, parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Film) = with(itemView) {
            val title = findViewById<TextView>(R.id.title)
            val imageView = findViewById<ImageView>(R.id.poster)

            title.text = item.title
            if (item.poster == null) {
                imageView.setImageResource(R.drawable.ic_default_image)
            } else {
                imageView.setImageResource(item.poster)
            }
        }
    }

    private class DiffUtilCallback : DiffUtil.ItemCallback<Film>() {

        override fun areItemsTheSame(
            oldItem: Film,
            newItem: Film,
        ): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: Film,
            newItem: Film,
        ): Boolean {
            return oldItem == newItem
        }
    }
}