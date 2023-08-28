package com.coffee.kmpapi.impl.rockets.data

sealed class RocketResponse {
    object Loading : RocketResponse()
    data class Error(val e: Exception) : RocketResponse()
    data class Success(val data: List<RocketModel>) : RocketResponse()
}