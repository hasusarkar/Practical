package com.practical.model.channel

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class IconAsset {
    @SerializedName("thumbnailUrl")
    @Expose
    val thumbnailUrl: String? = null

    @SerializedName("url")
    @Expose
    val url: String? = null
}