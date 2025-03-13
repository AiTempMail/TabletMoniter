package com.example.tabletmonitor.api

import com.google.gson.annotations.SerializedName

data class PriceHistoryResponse(
    @SerializedName("prices") val prices: List<Float>,
    @SerializedName("months") val months: List<String>
)