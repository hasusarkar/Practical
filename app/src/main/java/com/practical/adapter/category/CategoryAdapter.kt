package com.practical.adapter.category

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practical.R
import com.practical.activity.MainActivity
import com.practical.model.category.Category

class CategoryAdapter(var context: Context, var episodeList: List<Category>) : RecyclerView.Adapter<CategoryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        holder.bind(episodeList[position])
    }

    override fun getItemCount(): Int {
        return episodeList.size
    }
}