package com.practical.adapter.category

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.practical.model.category.Category
import kotlinx.android.synthetic.main.item_category.view.*


class CategoryItemViewHolder  (itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(allData: Category) {
        itemView.itemCategory.text=allData.name
    }
}