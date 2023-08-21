package com.coffee.kmpapi.impl.mission


interface MissionRepo {
    suspend fun getMissionDetailsList(): List<MissionModel>
}