package com.practical

import com.google.gson.reflect.TypeToken
import com.practical.model.category.CategoryData
import com.practical.model.channel.ChannelData
import com.practical.model.newepisode.EpisodeData


class AppConstant {
    companion object {
        val Base_Url = "https://pastebin.com/raw/"
        var typeEpisodeData = object : TypeToken<EpisodeData?>() {}.type
        var typeChannelData = object : TypeToken<ChannelData?>() {}.type
        var typeCategoryData = object : TypeToken<CategoryData?>() {}.type
    }
}