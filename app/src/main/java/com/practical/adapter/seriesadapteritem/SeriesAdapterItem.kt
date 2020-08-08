package com.practical.adapter.seriesadapteritem

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practical.R
import com.practical.activity.MainActivity
import com.practical.model.channel.Series

class SeriesAdapterItem(var context: Context, var episodeList: List<Series>) : RecyclerView.Adapter<SeriesViewHolderItem>() {
    private var screenWidth = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolderItem {
        val displayMetrics = DisplayMetrics()
        (context as MainActivity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenWidth = displayMetrics.widthPixels

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_series, parent, false)
        return SeriesViewHolderItem(view)
    }

    override fun onBindViewHolder(holder: SeriesViewHolderItem, position: Int) {
        holder.bind(episodeList[position],screenWidth)
    }

    override fun getItemCount(): Int {
        return episodeList.size
    }
}