package com.practical.adapter.episodeadapter

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practical.R
import com.practical.activity.MainActivity
import com.practical.model.newepisode.Medium

class EpisodeAdapter(var context: Context, var episodeList: List<Medium>) : RecyclerView.Adapter<EpisodeViewHolderItem>() {
    private var screenWidth = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolderItem {
        val displayMetrics = DisplayMetrics()
        (context as MainActivity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenWidth = displayMetrics.widthPixels

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_episode, parent, false)
        return EpisodeViewHolderItem(view)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolderItem, position: Int) {
        holder.bind(episodeList[position],screenWidth)
    }

    override fun getItemCount(): Int {
        return episodeList.size
    }

}