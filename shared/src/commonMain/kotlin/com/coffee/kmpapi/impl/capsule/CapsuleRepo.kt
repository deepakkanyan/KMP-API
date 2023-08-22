package com.coffee.kmpapi.impl.capsule

import com.coffee.kmpapi.impl.rockets.RocketModel

interface CapsuleRepo {
    suspend fun getAllCapsuleDetailsList(): List<RocketModel>
}