package com.practical.adapter.seriesadapter

import android.graphics.Bitmap
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.transition.Transition
import com.practical.R
import com.practical.adapter.courseadapter.CourseAdapter
import com.practical.adapter.seriesadapteritem.SeriesAdapterItem
import com.practical.model.channel.Channel
import kotlinx.android.synthetic.main.item_channel_series.view.*



class ChannelSeriesViewHolder (
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    lateinit var image:String
    fun bind(item: Channel, screenWidth: Int) {

        if(item.series?.size==0){
            itemView.itemChannelSeriesTitle.text=item.title
            itemView.itemChannelSeriesCount.text=item.mediaCount.toString()+" "+itemView.context.resources.getString(R.string.episodes)
            if(item.iconAsset!=null){
                if(item.iconAsset.url!=null){
                    image= item.iconAsset.url!!
                }

                if(item.iconAsset.thumbnailUrl!=null){
                    image= item.iconAsset.thumbnailUrl!!
                }

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
                            .into(object : BitmapImageViewTarget(itemView.itemChannelSeriesImage) {
                                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                                    super.onResourceReady(resource, transition)
                                    itemView.itemChannelSeriesImage.setImageBitmap(resource)//This is important
                                }
                            })
                    }
                }

            }

            val linearLayoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            itemView.itemChannelSeriesRecylerList.layoutManager = linearLayoutManager

            val courseAdapter = CourseAdapter(itemView.context, item.latestMedia!!)
//            val seriesadapteritem = SeriesAdapterItem(itemView.context, item.series!!)
            itemView.itemChannelSeriesRecylerList.adapter = courseAdapter

        }else{
            itemView.itemChannelSeriesTitle.text=item.title
            itemView.itemChannelSeriesCount.text=item.mediaCount.toString()+" "+itemView.context.resources.getString(R.string.episodes)

            if(item.iconAsset!=null){
                if(item.iconAsset.url!=null){
                    image= item.iconAsset.url!!
                }

                if(item.iconAsset.thumbnailUrl!=null){
                    image= item.iconAsset.thumbnailUrl!!
                }

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
                            .into(object : BitmapImageViewTarget(itemView.itemChannelSeriesImage) {
                                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                                    super.onResourceReady(resource, transition)
                                    itemView.itemChannelSeriesImage.setImageBitmap(resource)//This is important
                                }
                            })
                    }
                }
            }
            val linearLayoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            itemView.itemChannelSeriesRecylerList.layoutManager = linearLayoutManager

            val seriesadapteritem = SeriesAdapterItem(itemView.context, item.series!!)
            itemView.itemChannelSeriesRecylerList.adapter = seriesadapteritem

        }

    }
}