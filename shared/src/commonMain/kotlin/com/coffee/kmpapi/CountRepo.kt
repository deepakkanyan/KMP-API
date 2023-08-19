package com.coffee.kmpapi


interface CountRepo{
    suspend fun getSumOfTwo(a: Int,b : Int) : Int
}