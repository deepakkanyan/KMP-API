package com.coffee.kmpapi.impl.rockets

import com.coffee.kmpapi.impl.rockets.data.RocketModel

interface RocketRepo {
    suspend fun getAllRocketDetailsList(): List<RocketModel>
}