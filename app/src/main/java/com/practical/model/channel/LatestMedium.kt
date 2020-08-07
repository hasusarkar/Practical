package com.practical.model.channel

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class LatestMedium {
    @SerializedName("type")
    @Expose
    val type: String? = null

    @SerializedName("title")
    @Expose
    val title: String? = null

    @SerializedName("coverAsset")
    @Expose
    val coverAsset: CoverAsset_? = null
}