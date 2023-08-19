package com.coffee.kmpapi.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coffee.kmpapi.CountRepoImpl
import com.coffee.kmpapi.GetSumOfTwoUseCase
import com.coffee.kmpapi.impl.rockets.RocketModel
import com.coffee.kmpapi.impl.rockets.usecases.GetRocketListUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountViewModel(private val getCount: GetSumOfTwoUseCase = GetSumOfTwoUseCase(CountRepoImpl())) :
    ViewModel() {

    private var _countEven = MutableStateFlow(0)
    val countEven: StateFlow<Int>
        get() = _countEven.asStateFlow()


    private var _rocketList = MutableSharedFlow<List<RocketModel>>()
    val rocketList: SharedFlow<List<RocketModel>>
        get() = _rocketList.asSharedFlow()


    init {
        countIt(10,5)
    }


    private fun countIt(a: Int, b: Int) {
        viewModelScope.launch {
            _countEven.value =  getCount.invoke(a, b)
        }
    }


     fun getRocketList(){
        viewModelScope.launch {
           // _rocketList.emit(GetRocketListUseCase.invoke())
        }
    }

}