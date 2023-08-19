package com.coffee.kmpapi

class GetSumOfTwoUseCase(private val repoImpl: CountRepoImpl) {
    suspend operator fun invoke(a: Int, b: Int) = repoImpl.getSumOfTwo(a, b)
}