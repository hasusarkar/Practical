package com.practical.adapter.seriesadapter

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practical.R
import com.practical.activity.MainActivity
import com.practical.adapter.seriesadapteritem.SeriesViewHolderItem
import com.practical.model.channel.Channel

class SeriesAdapter(var context: Context, var episodeList: List<Channel>) : RecyclerView.Adapter<ChannelSeriesViewHolder>() {
    private var screenWidth = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelSeriesViewHolder {
        val displayMetrics = DisplayMetrics()
        (context as MainActivity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenWidth = displayMetrics.widthPixels

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_channel_series, parent, false)
        return ChannelSeriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChannelSeriesViewHolder, position: Int) {
        holder.bind(episodeList[position],screenWidth)
    }

    override fun getItemCount(): Int {
        return episodeList.size
    }
}