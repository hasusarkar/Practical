package com.practical.viewmodel

import androidx.lifecycle.MutableLiveData
import com.practical.BaseViewModel
import com.practical.model.AllData
import com.practical.model.category.CategoryData
import com.practical.model.channel.ChannelData
import com.practical.model.newepisode.EpisodeData
import com.practical.repository.MindTokeRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody


class MindTokeViewModel(private val mindtokeRepository: MindTokeRepository) : BaseViewModel() {

    val episodeObserver: MutableLiveData<EpisodeData> = MutableLiveData()
    val channelObserver: MutableLiveData<ChannelData> = MutableLiveData()
    val categoryObserver: MutableLiveData<CategoryData> = MutableLiveData()


    suspend fun getEpisodeRequest() {
        try {
            val userEpisodeResponse = mindtokeRepository.getEpisode()
            if (userEpisodeResponse != null) {
                episodeObserver.postValue(userEpisodeResponse)
            } else {
                isThrowData.postValue(ThrowError(null, false, ""))
                episodeObserver.postValue(userEpisodeResponse)
            }
        } catch (e: java.lang.Exception) {
            isThrowData.postValue(ThrowError(null, false,""))
            e.printStackTrace()
        }
    }

    suspend fun getChannelRequest() {
        try {
            val userChannelResponse = mindtokeRepository.getChannel()
            if (userChannelResponse != null) {
                channelObserver.postValue(userChannelResponse)
            } else {
                isThrowData.postValue(ThrowError(null, false, ""))
                channelObserver.postValue(userChannelResponse)
            }
        } catch (e: java.lang.Exception) {
            isThrowData.postValue(ThrowError(null, false,""))
            e.printStackTrace()
        }
    }
    suspend fun getCategoryRequest() {
        try {
            val userCategoryResponse = mindtokeRepository.getCategory()
            if (userCategoryResponse != null) {
                categoryObserver.postValue(userCategoryResponse)
            } else {
                isThrowData.postValue(ThrowError(null, false, ""))
                categoryObserver.postValue(userCategoryResponse)
            }
        } catch (e: java.lang.Exception) {
            isThrowData.postValue(ThrowError(null, false,""))
            e.printStackTrace()
        }
    }
}