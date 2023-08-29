package com.coffee.kmpapi.impl.capsule

import com.coffee.kmpapi.impl.capsule.model.CapModel

interface CapsuleRepo {
    suspend fun getAllCapsuleDetailsList(): List<CapModel>
}