package com.practical.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practical.adapter.episodeadapter.EpisodeAdapter
import com.practical.model.AllData
import kotlinx.android.synthetic.main.episode_item.view.*

class EpisodeViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(allData: AllData, screenWidth: Int) {


        val episodeList=allData.episodeList

        val linearLayoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
        itemView.itemEpisodeRecylerList.layoutManager = linearLayoutManager

        val episodeAdapter = EpisodeAdapter(itemView.context, episodeList)
        itemView.itemEpisodeRecylerList.adapter = episodeAdapter

        val itemWidth = screenWidth / 1.3

//        val lp = itemExplorerMainLayout.layoutParams
//        lp.height = lp.height
//        lp.width = itemWidth.toInt()
//        itemExplorerMainLayout.layoutParams = lp
//
//        val name=item.authorFirstname+" "+item.authorLastname
//        itemTourUserName.text = name
//
//
//        if (item.authorProfileImage != null) {
//            if (item.authorProfileImage.isNotEmpty()) {
//                val image = item.authorProfileImage
//                val options = RequestOptions()
//                    .placeholder(R.drawable.ic_noimage)
//                    .error(R.drawable.ic_noimage)
//
//                Glide.with(itemView.context)
//                    .asBitmap()
//                    .load(image)
//                    .apply(options)
//                    .into(object : BitmapImageViewTarget(itemTourProfileImg) {
//                        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
//                            super.onResourceReady(resource, transition)
//                            itemTourProfileImg.setImageBitmap(resource)//This is important
//                        }
//                    })
//            }
//        }
    }
}