package com.coffee.kmpapi.impl.mission.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MissionModel(
    @SerialName("mission_name")
    val missionName: String,
    @SerialName("mission_id")
    val missionId: String,
    @SerialName("manufacturers")
    val manufacturers: List<String>,
    @SerialName("payload_ids")
    val payloadIds: List<String>,
    @SerialName("wikipedia")
    val wikipedia: String?,
    @SerialName("website")
    val website: String?,
    @SerialName("twitter")
    val twitter: String? ,
    @SerialName("description")
    val description: String
)