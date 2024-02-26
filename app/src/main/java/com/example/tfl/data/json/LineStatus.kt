package com.example.tfl.data.json


import com.google.gson.annotations.SerializedName

data class LineStatus(
    @SerializedName("created")
    val created: String? = "",
    @SerializedName("disruption")
    val disruption: Disruption? = Disruption(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("lineId")
    val lineId: String? = "",
    @SerializedName("reason")
    val reason: String? = "",
    @SerializedName("statusSeverity")
    val statusSeverity: Int? = 0,
    @SerializedName("statusSeverityDescription")
    val statusSeverityDescription: String? = "",
    @SerializedName("\$type")
    val type: String? = "",
    @SerializedName("validityPeriods")
    val validityPeriods: List<ValidityPeriod?>? = listOf()
)