package com.coffee.kmpapi.impl.capsule

import com.coffee.kmpapi.impl.capsule.model.CapModel
import com.coffee.kmpapi.remote.ProjectXApi
import com.coffee.kmpapi.utils.ApisUrls
import io.ktor.client.call.body
import io.ktor.client.request.get

class CapImpl : CapsuleRepo {
    override suspend fun getAllCapsuleDetailsList(): List<CapModel> {
        return ProjectXApi.httpClient.get(ApisUrls.EndUrlV4.plus("capsules")).body()
    }
}