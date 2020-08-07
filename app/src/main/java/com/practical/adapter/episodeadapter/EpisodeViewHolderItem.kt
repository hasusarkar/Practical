package com.practical.adapter.episodeadapter

import android.graphics.Bitmap
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.transition.Transition
import com.practical.R
import com.practical.model.newepisode.Medium
import kotlinx.android.synthetic.main.item_episode.view.*

class EpisodeViewHolderItem (
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Medium, screenWidth: Int) {

        val itemWidth = screenWidth / 2

        val lp = itemView.layoutEpisode.layoutParams
        lp.height = lp.height
        lp.width = itemWidth.toInt()
        itemView.layoutEpisode.layoutParams = lp

        itemView.itemTitle.text = item.title
        itemView.itemText.text=item.channel?.title

        val image=item.coverAsset?.url
        if (image != null) {
            if (image.isNotEmpty()) {
                val options = RequestOptions()
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)

                Glide.with(itemView.context)
                    .asBitmap()
                    .load( image)
                    .apply(options)
//                    .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
                    .into(object : BitmapImageViewTarget(itemView.itemEpisode) {
                        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                            super.onResourceReady(resource, transition)
                            itemView.itemEpisode.setImageBitmap(resource)//This is important
                        }
                    })
            }
        }

    }


}