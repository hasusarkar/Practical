package com.practical

import android.content.Context
import com.google.gson.Gson
import com.practical.model.category.CategoryData
import com.practical.model.channel.ChannelData
import com.practical.model.newepisode.EpisodeData
import com.practical.prefUtils.SharedPrefrenceUtils

object UtilityData {
    fun getEpisodeData(context: Context): EpisodeData {
        var fromJson = EpisodeData()
        val getRegisterData = SharedPrefrenceUtils.getStringPref(context, SharedPrefrenceUtils.PREF_EPISODE_DATA)
        if (getRegisterData?.isNotEmpty()!!) {
            fromJson = Gson().fromJson(getRegisterData, AppConstant.typeEpisodeData)
        }
        return fromJson
    }
    fun getChannelData(context: Context): ChannelData {
        var fromJson = ChannelData()
        val getRegist = SharedPrefrenceUtils.getStringPref(context, SharedPrefrenceUtils.PREF_CHANNEL_DATA)
        if (getRegist?.isNotEmpty()!!) {
            fromJson = Gson().fromJson(getRegist, AppConstant.typeChannelData)
        }
        return fromJson
    }

    fun getCategoryData(context: Context): CategoryData {
        var fromJson = CategoryData()
        val getRegist = SharedPrefrenceUtils.getStringPref(context, SharedPrefrenceUtils.PREF_CATEGORY_DATA)
        if (getRegist?.isNotEmpty()!!) {
            fromJson = Gson().fromJson(getRegist, AppConstant.typeCategoryData)
        }
        return fromJson
    }
}