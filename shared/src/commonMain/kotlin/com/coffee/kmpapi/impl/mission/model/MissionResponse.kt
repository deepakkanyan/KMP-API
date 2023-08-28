package com.coffee.kmpapi.impl.mission.model


sealed class MissionResponse {
    object Loading : MissionResponse()
    data class Error(val e: Exception) : MissionResponse()
    data class Success(val data: List<MissionModel>) : MissionResponse()
}