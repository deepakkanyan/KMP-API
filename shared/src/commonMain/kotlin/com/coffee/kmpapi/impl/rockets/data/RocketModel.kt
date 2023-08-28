package com.coffee.kmpapi.impl.rockets.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RocketModel(
    val name: String,
    val country: String,
    val company: String,
    val description: String,
    @SerialName("cost_per_launch")
    val cost: Int,
    @SerialName("flickr_images")
    val rocketsImages : List<String>
)