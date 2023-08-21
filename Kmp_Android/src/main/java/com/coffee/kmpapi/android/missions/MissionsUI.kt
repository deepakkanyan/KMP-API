package com.coffee.kmpapi.android.missions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coffee.kmpapi.android.utils.ui.KmpResultSurface
import com.coffee.kmpapi.impl.mission.MissionModel

@Composable
fun MissionsUI() {
    val viewModel: MissionViewModel = viewModel()
    Box {

        KmpResultSurface(
            networkStatus = viewModel.missionList.collectAsState().value,
            onSuccess = {
                ShowMissionList(mission = it)
            },
        )
    }

}

@Composable
fun ShowMissionList(mission: List<MissionModel>) {
    LazyColumn {
        items(mission) {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .wrapContentHeight()
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp)

            ) {

                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = it.missionName,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = it.website.orEmpty(),
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        text = it.description,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}