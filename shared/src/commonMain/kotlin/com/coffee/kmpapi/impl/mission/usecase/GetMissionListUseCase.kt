package com.coffee.kmpapi.impl.mission.usecase

import com.coffee.kmpapi.impl.mission.MissionImpl
import com.coffee.kmpapi.impl.mission.model.MissionResponse

object GetMissionListUseCase {
    private val repo = MissionImpl()
    suspend operator fun invoke(): MissionResponse  {
        return try {
            MissionResponse.Success(repo.getMissionDetailsList())
        } catch (e: Exception) {
            MissionResponse.Error(e)
        }
    }
}