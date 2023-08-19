package com.coffee.kmpapi

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform