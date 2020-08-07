package com.practical.model

import com.practical.model.category.Category
import com.practical.model.category.CategoryData
import com.practical.model.channel.Channel
import com.practical.model.channel.ChannelData
import com.practical.model.newepisode.EpisodeData
import com.practical.model.newepisode.Medium

class AllData {
    var type:Int=0
    lateinit var episodeList: List<Medium>
    lateinit var channelList: List<Channel>
    lateinit var categoryList: List<Category>
}