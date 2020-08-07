package com.practical.http



import com.practical.model.AllData
import com.practical.model.category.CategoryData
import com.practical.model.channel.ChannelData
import com.practical.model.newepisode.EpisodeData
import retrofit2.Response
import retrofit2.http.*


interface ApiService {
    @GET("z5AExTtw")
    suspend fun callEpisode(): Response<EpisodeData>
    @GET("Xt12uVhM")
    suspend fun callChannel(): Response<ChannelData>
    @GET("A0CgArX3")
    suspend fun callCategory(): Response<CategoryData>
}
