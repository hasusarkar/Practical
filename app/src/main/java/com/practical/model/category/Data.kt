package com.practical.model.category

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Data {

    @SerializedName("categories")
    @Expose
    val categories: List<Category>? = null
}