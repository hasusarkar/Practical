package com.practical.adapter.courseadapter

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practical.R
import com.practical.activity.MainActivity
import com.practical.model.channel.LatestMedium

class CourseAdapter(var context: Context, var episodeList: List<LatestMedium>) : RecyclerView.Adapter<CourseViewHolder>() {
    private var screenWidth = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val displayMetrics = DisplayMetrics()
        (context as MainActivity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenWidth = displayMetrics.widthPixels

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(episodeList[position],screenWidth)
    }

    override fun getItemCount(): Int {
        return episodeList.size
    }

}