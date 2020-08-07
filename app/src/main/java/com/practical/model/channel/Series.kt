package com.practical.model.channel

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Series {
    @SerializedName("title")
    @Expose
    val title: String? = null

    @SerializedName("coverAsset")
    @Expose
    val coverAsset: CoverAsset? = null

    @SerializedName("id")
    @Expose
    val id: String? = null
}