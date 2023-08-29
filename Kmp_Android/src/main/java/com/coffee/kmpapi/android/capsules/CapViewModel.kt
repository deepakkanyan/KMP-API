package com.coffee.kmpapi.android.capsules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coffee.kmpapi.impl.capsule.model.CapResponse
import com.coffee.kmpapi.impl.capsule.usecases.GetAllCap
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CapViewModel : ViewModel() {

    private var _capList = MutableStateFlow<CapResponse>(CapResponse.Loading)
    val capList = _capList.asStateFlow()


    init {
        fetchRockets()
    }

    private fun fetchRockets() {
        viewModelScope.launch {
            _capList.value = GetAllCap.invoke()
        }
    }
}