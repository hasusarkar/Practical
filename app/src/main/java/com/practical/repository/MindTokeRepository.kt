package com.practical.repository


import com.practical.BaseRepository
import com.practical.http.ApiService
import com.practical.model.AllData
import com.practical.model.category.CategoryData
import com.practical.model.channel.ChannelData
import com.practical.model.newepisode.EpisodeData
import okhttp3.MultipartBody
import okhttp3.RequestBody


class MindTokeRepository(val api: ApiService) : BaseRepository() {

    suspend fun getEpisode(): EpisodeData? {
        return safeApiCall(
            call = { api.callEpisode() },
            errorMessage = "Error fetching Data"
        )
    }
    suspend fun getChannel(): ChannelData? {
        return safeApiCall(
            call = { api.callChannel() },
            errorMessage = "Error fetching Data"
        )
    }
    suspend fun getCategory(): CategoryData? {
        return safeApiCall(
            call = { api.callCategory() },
            errorMessage = "Error fetching Data"
        )
    }
}