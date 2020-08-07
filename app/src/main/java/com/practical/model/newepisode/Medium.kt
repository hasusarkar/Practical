package com.practical.model.newepisode

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Medium {

    @SerializedName("type")
    @Expose
    val type: String? = null

    @SerializedName("title")
    @Expose
    val title: String? = null

    @SerializedName("coverAsset")
    @Expose
    val coverAsset: CoverAsset? = null

    @SerializedName("channel")
    @Expose
    val channel: Channel? = null
}