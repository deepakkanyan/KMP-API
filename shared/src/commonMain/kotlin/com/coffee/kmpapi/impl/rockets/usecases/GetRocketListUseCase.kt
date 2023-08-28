package com.coffee.kmpapi.impl.rockets.usecases

import com.coffee.kmpapi.impl.rockets.RocketImpl
import com.coffee.kmpapi.impl.rockets.data.RocketResponse

object GetRocketListUseCase {
    private val repo = RocketImpl()
    suspend operator fun invoke(): RocketResponse {
        return try {
            RocketResponse.Success(repo.getAllRocketDetailsList())
        } catch (e: Exception) {
            RocketResponse.Error(e)
        }
    }
}
