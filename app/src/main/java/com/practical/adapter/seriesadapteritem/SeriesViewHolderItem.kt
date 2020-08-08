package com.practical.adapter.seriesadapteritem

import android.graphics.Bitmap
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.transition.Transition
import com.practical.R
import com.practical.model.channel.Series
import kotlinx.android.synthetic.main.item_series.view.*

class SeriesViewHolderItem (
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Series, screenWidth: Int) {

        val itemWidth = screenWidth / 1.2

        val lp = itemView.layoutSeries.layoutParams
        lp.height = lp.height
        lp.width = itemWidth.toInt()
        itemView.layoutSeries.layoutParams = lp

        itemView.itemSeriesTitle.text=item.title

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
                    .into(object : BitmapImageViewTarget(itemView.itemSeries) {
                        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                            super.onResourceReady(resource, transition)
                            itemView.itemSeries.setImageBitmap(resource)//This is important
                        }
                    })
            }
        }
    }
}