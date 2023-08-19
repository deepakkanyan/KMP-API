package com.coffee.kmpapi.impl.rockets

interface RocketRepo {
    suspend fun getAllRocketDetailsList(): List<RocketModel>
}