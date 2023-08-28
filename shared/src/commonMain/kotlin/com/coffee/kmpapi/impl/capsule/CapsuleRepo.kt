package com.coffee.kmpapi.impl.capsule

import com.coffee.kmpapi.impl.rockets.data.RocketModel

interface CapsuleRepo {
    suspend fun getAllCapsuleDetailsList(): List<RocketModel>
}