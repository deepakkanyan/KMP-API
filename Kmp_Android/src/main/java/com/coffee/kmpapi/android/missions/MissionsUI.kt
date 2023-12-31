package com.coffee.kmpapi.android.missions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coffee.kmpapi.android.utils.ui.views.KmpLinkIcon
import com.coffee.kmpapi.impl.mission.model.MissionModel
import com.coffee.kmpapi.impl.mission.model.MissionResponse

@Composable
fun MissionsUI() {
    val viewModel: MissionViewModel = viewModel()
    val mission = viewModel.missionList.collectAsState().value

    Box(modifier = Modifier) {
        MissionView(mission)
    }

}

@Composable
fun BoxScope.MissionView(mission: MissionResponse) {

    when (mission) {
        is MissionResponse.Loading -> {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        is MissionResponse.Success -> {
            ShowMissionList(mission.data)
        }

        is MissionResponse.Error -> {
            Text(text = mission.e.toString(), modifier = Modifier.align(Alignment.Center))
        }

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
                    Spacer(modifier = Modifier.padding(top = 5.dp))
                    Text(
                        text = it.description,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )

                    Spacer(modifier = Modifier.padding(top = 10.dp))

                    Row {
                        KmpLinkIcon(imageVector = Icons.Sharp.Info, it.wikipedia)
                        KmpLinkIcon(imageVector = Icons.Sharp.AccountCircle, it.twitter)
                        KmpLinkIcon(imageVector = Icons.Sharp.Home, it.website)
                    }
                }
            }
        }
    }
}