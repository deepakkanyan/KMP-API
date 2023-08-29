package com.coffee.kmpapi.impl.capsule.model

sealed class CapResponse {
    object Loading : CapResponse()
    data class Error(val e: Exception) : CapResponse()
    data class Success(val data: List<CapModel>) : CapResponse()
}
