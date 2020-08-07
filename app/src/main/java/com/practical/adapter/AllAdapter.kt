package com.practical.adapter

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practical.R
import com.practical.activity.MainActivity
import com.practical.model.AllData


class AllAdapter(var context: Context,var allDataList: List<AllData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var screenWidth = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val displayMetrics = DisplayMetrics()
        (context as MainActivity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenWidth = displayMetrics.widthPixels

        val view: View
        if (viewType == 1) { // for call layout
            view = LayoutInflater.from(context).inflate(R.layout.episode_item, parent, false);
            return EpisodeViewHolder(view)
        } else if(viewType==2){ // for email layout
            view = LayoutInflater.from(context).inflate(R.layout.series_item, parent, false);
            return SeriesViewHolder(view)
        }else{ // for email layout
            view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
            return CategoryViewHolder(view)
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if (allDataList[position].type == 1) {
            (viewHolder as EpisodeViewHolder).bind(allDataList[position],screenWidth)
        } else if(allDataList[position].type == 2) {
            (viewHolder as SeriesViewHolder).bind(allDataList[position],screenWidth)
        }else if(allDataList[position].type == 3) {
            (viewHolder as CategoryViewHolder).bind(allDataList[position],screenWidth)
        }
    }

    override fun getItemCount(): Int {
        return allDataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return allDataList[position].type
    }
    fun updateData(allDataList: List<AllData>) {
        this.allDataList=allDataList
        notifyDataSetChanged()
    }

}