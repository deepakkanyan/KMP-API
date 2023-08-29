package com.coffee.kmpapi.impl.capsule.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CapModel(
    @SerialName("reuse_count")
    val reuseCount: Long,
    @SerialName("water_landings")
    val waterLandings: Long,
    @SerialName("land_landings")
    val landLandings: Long,
    @SerialName("last_update")
    val lastUpdate: String? = null,
    val launches: List<String>,
    val serial: String,
    val status: String,
    val type: String,
    val id: String
)