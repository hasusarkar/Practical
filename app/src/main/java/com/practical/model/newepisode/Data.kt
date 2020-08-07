package com.practical.model.newepisode

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Data {
    @SerializedName("media")
    @Expose
    val media: List<Medium>? = null
}