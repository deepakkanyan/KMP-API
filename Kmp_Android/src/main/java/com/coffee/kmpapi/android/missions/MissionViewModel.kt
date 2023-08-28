package com.coffee.kmpapi.android.missions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coffee.kmpapi.impl.mission.model.MissionResponse
import com.coffee.kmpapi.impl.mission.usecase.GetMissionListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MissionViewModel : ViewModel() {

    private var _missionList = MutableStateFlow<MissionResponse>(MissionResponse.Loading)
    val missionList  = _missionList.asStateFlow()

    init {
        fetchMissions()
    }

    private fun fetchMissions() {
        viewModelScope.launch {
            _missionList.value = GetMissionListUseCase.invoke()
        }
    }
}