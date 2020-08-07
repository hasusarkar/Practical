package com.practical.model.channel

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Data {
    @SerializedName("channels")
    @Expose
    val channels: List<Channel>? = null
}