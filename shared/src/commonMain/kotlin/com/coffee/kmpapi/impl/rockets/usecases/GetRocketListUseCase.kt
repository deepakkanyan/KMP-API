package com.coffee.kmpapi.impl.rockets.usecases

import com.coffee.kmpapi.impl.rockets.RocketImpl
import com.coffee.kmpapi.impl.rockets.RocketModel

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

sealed class RocketResponse {
    object Loading : RocketResponse()
    data class Error(val e: Exception) : RocketResponse()
    data class Success(val data: List<RocketModel>) : RocketResponse()
}