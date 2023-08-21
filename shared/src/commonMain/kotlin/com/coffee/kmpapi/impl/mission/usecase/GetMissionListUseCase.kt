package com.coffee.kmpapi.impl.mission.usecase

import com.coffee.kmpapi.impl.mission.MissionImpl
import com.coffee.kmpapi.impl.mission.MissionModel
import com.coffee.kmpapi.utils.KmpResponse

object GetMissionListUseCase {
    private val repo = MissionImpl()
    suspend operator fun invoke(): KmpResponse<List<MissionModel>> {
        return try {
            KmpResponse.Success(repo.getMissionDetailsList())
        } catch (e: Exception) {
            KmpResponse.Error(e)
        }
    }
}