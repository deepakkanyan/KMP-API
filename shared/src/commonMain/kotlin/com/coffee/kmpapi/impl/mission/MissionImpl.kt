package com.coffee.kmpapi.impl.mission

import com.coffee.kmpapi.remote.ProjectXApi
import com.coffee.kmpapi.utils.ApisUrls
import io.ktor.client.call.body
import io.ktor.client.request.get

class MissionImpl : MissionRepo {
    override suspend fun getMissionDetailsList(): List<MissionModel> {
        return ProjectXApi.httpClient.get(ApisUrls.EndUrlV3.plus("missions")).body()
    }
}