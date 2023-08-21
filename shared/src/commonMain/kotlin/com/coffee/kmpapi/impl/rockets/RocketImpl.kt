package com.coffee.kmpapi.impl.rockets

import com.coffee.kmpapi.remote.ProjectXApi
import com.coffee.kmpapi.utils.ApisUrls
import io.ktor.client.call.body
import io.ktor.client.request.get

class RocketImpl : RocketRepo {
    override suspend fun getAllRocketDetailsList(): List<RocketModel> {
        return ProjectXApi.httpClient.get(ApisUrls.EndUrlV4.plus("rockets")).body()
    }
}