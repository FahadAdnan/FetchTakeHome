package com.example.fetchtakehome.model

import com.google.gson.annotations.SerializedName

data class HiringItem(
    @SerializedName("id")
    val id: String,

    @SerializedName("listId")
    val listId: String,

    @SerializedName("name")
    val name: String?,
)