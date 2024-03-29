package com.periculum.internal.api

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.periculum.internal.models.AnalyticsModel
import com.periculum.internal.models.PublicKey
import com.periculum.internal.models.SenderAddress
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


internal interface PericulumApi {

    @POST("/mobile/sms-address-list")
    fun getSenderAddress(
        @Body publicKey: PublicKey
    ): Call<SenderAddress>
    @POST("/mobile/analytics")
    fun postAnalytics(
        @Body analyticsBody: AnalyticsModel
    ): Call<JsonArray>

    @POST("/mobile/insights/v2")
    fun mobileInsightsV2(
        @Body analyticsBody: AnalyticsModel
    ): Call<JsonObject>

    @PATCH("/mobile/insights/v2/{overviewKey}")
    fun updateMobileInsightV2(
        @Path("overviewKey") overviewKey: String,
        @Body analyticsBody: AnalyticsModel,
    ): Call<JsonObject>


}