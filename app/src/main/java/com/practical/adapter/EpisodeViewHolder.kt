package com.practical.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practical.adapter.episodeadapter.EpisodeAdapter
import com.practical.model.AllData
import kotlinx.android.synthetic.main.episode_item.view.*

class EpisodeViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(allData: AllData) {
        val episodeList=allData.episodeList

        val linearLayoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
        itemView.itemEpisodeRecylerList.layoutManager = linearLayoutManager

        val episodeAdapter = EpisodeAdapter(itemView.context, episodeList)
        itemView.itemEpisodeRecylerList.adapter = episodeAdapter
    }
}