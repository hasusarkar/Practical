package com.practical.model.channel

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Channel {
    @SerializedName("title")
    @Expose
    val title: String? = null

    @SerializedName("series")
    @Expose
    val series: List<Series>? = null

    @SerializedName("mediaCount")
    @Expose
    val mediaCount: Int? = null

    @SerializedName("latestMedia")
    @Expose
    val latestMedia: List<LatestMedium>? = null

    @SerializedName("id")
    @Expose
    val id: String? = null

    @SerializedName("iconAsset")
    @Expose
    val iconAsset: Any? = null

    @SerializedName("coverAsset")
    @Expose
    val coverAsset: CoverAsset__? = null

    @SerializedName("slug")
    @Expose
    val slug: String? = null

}