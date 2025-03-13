package com.example.tabletmonitor.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DrugApiService {
    @GET("api/drug-info")
    suspend fun getDrugInfo(
        @Query("name") drugName: String
    ): Response<DrugInfoResponse>

    @GET("api/price-history")
    suspend fun getPriceHistory(
        @Query("name") drugName: String
    ): Response<PriceHistoryResponse>
}