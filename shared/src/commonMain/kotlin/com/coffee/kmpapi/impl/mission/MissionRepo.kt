package com.coffee.kmpapi.impl.mission

import com.coffee.kmpapi.impl.mission.model.MissionModel

interface MissionRepo {
    suspend fun getMissionDetailsList(): List<MissionModel>
}