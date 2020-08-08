package com.practical.adapter

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practical.R
import com.practical.adapter.seriesadapter.SeriesAdapter
import com.practical.model.AllData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.series_item.view.*


class SeriesViewHolder  (itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(allData: AllData) {
        val channelList=allData.channelList

        val linearLayoutManager = LinearLayoutManager(itemView.context, RecyclerView.VERTICAL, false)
        itemView.itemChannelRecylerList.layoutManager = linearLayoutManager

//        for(i in 0 until channelList.size){
//            if(channelList[i].series?.size==0){
//                channelList[i].type=1
//            }else{
//                channelList[i].type=2
//            }
//        }
        val seriesAdapter = SeriesAdapter(itemView.context, channelList)
        val divider = DividerItemDecoration(itemView.itemChannelRecylerList.context, DividerItemDecoration.VERTICAL)
        divider.setDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.line_divider)!!)
        itemView.itemChannelRecylerList.addItemDecoration(divider)
        itemView.itemChannelRecylerList.adapter = seriesAdapter
    }
}