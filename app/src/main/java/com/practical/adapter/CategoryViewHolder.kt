package com.practical.adapter

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practical.adapter.category.CategoryAdapter
import com.practical.model.AllData
import kotlinx.android.synthetic.main.category_item.view.*


class CategoryViewHolder  (itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(allData: AllData) {
        val categoryList=allData.categoryList

//        val linearLayoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
        itemView.categoryRecylerView.layoutManager =GridLayoutManager(itemView.context,2)

        val categoryAdapter = CategoryAdapter(itemView.context, categoryList)
        itemView.categoryRecylerView.adapter = categoryAdapter
    }
}