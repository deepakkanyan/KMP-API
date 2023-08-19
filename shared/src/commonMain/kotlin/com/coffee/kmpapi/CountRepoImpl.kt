package com.coffee.kmpapi

class CountRepoImpl : CountRepo {
    override suspend fun getSumOfTwo(a: Int, b: Int): Int {
        return a.plus(b)
    }
}