package com.example.tabletmonitor.api

import com.google.gson.annotations.SerializedName

data class DrugInfoResponse(
    @SerializedName("description") val description: String,
    @SerializedName("sideEffects") val sideEffects: List<String>
)