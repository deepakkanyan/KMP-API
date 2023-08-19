package com.coffee.kmpapi.android.rockets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coffee.kmpapi.impl.rockets.usecases.GetRocketListUseCase
import com.coffee.kmpapi.impl.rockets.usecases.RocketResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RocketViewModel : ViewModel() {

    private var _rocketList = MutableStateFlow<RocketResponse>(RocketResponse.Loading)
    val rocketList: StateFlow<RocketResponse>
        get() = _rocketList.asStateFlow()


    init {
        fetchRockets()
    }

    private fun fetchRockets() {
        viewModelScope.launch {
            _rocketList.value = GetRocketListUseCase.invoke()
        }
    }

}