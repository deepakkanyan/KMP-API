package com.coffee.kmpapi.impl.capsule.usecases

import com.coffee.kmpapi.impl.capsule.CapImpl
import com.coffee.kmpapi.impl.capsule.model.CapResponse

object GetAllCap {
    private val capImpl = CapImpl()
    suspend operator fun invoke(): CapResponse {
        return try {
            CapResponse.Success(capImpl.getAllCapsuleDetailsList())
        } catch (e: Exception) {
            CapResponse.Error(e)
        }

    }
}